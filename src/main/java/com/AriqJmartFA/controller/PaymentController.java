package com.AriqJmartFA.controller;

import com.AriqJmartFA.*;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.AriqJmartFA.Invoice.Status.*;
import static com.AriqJmartFA.controller.AccountController.accountTable;
import static com.AriqJmartFA.controller.ProductController.productTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 2;
    public static final long ON_DELIVERY_LIMIT_MS = 3;
    public static final long ON_PROGRESS_LIMIT_MS = 4;
    public static final long WAITING_CONF_LIMIT_MS = 5;

    @JsonAutowired(filepath = "json/Payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;


    static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread-pp", PaymentController::timekeeper);


    @PostMapping("/{id}/accept")
    boolean accept(@RequestParam int id) {

        for(Payment payment : paymentTable) {

            if(id == payment.id) {
                if(payment.history.get(payment.history.size() - 1).status == WAITING_CONFIRMATION) {

                    Payment.Record newRecord = new Payment.Record(ON_PROGRESS, "on progress");
                    payment.history.add(newRecord);
                    return true;

                }
            }
        }

        return false;

    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@RequestParam int id) {

        for(Payment payment : paymentTable) {

            if(id == payment.id) {
                if(payment.history.get(payment.history.size() - 1).status == WAITING_CONFIRMATION) {

                    Payment.Record newRecord = new Payment.Record(CANCELLED, "cancelled");
                    payment.history.add(newRecord);
                    return true;

                }
            }
        }

        return false;

    }

    @PostMapping("/create")
    Payment create(@RequestParam int buyerId,
                   @RequestParam int productId,
                   @RequestParam int productCount,
                   @RequestParam String shipmentAddress,
                   @RequestParam byte shipmentPlan) {

        for(Account account : accountTable) {

            if(buyerId == account.id) {
                for(Product product : productTable) {

                    if(productId == product.id) {

                        double productPrice = Payment.getTotalPay(product);
                        if(account.balance >= productPrice * productCount) {

                            account.balance -= productPrice * productCount;

                            Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                            payment.history.add(new Payment.Record(WAITING_CONFIRMATION, "waiting"));
                            getJsonTable().add(payment);
                            poolThread.add(payment);

                            return payment;

                        }
                    }
                }
            }
        }

        return null;

    }

    public JsonTable<Payment> getJsonTable() {

        return paymentTable;

    }

    @PostMapping("/{id}/submit")
    boolean submit(@RequestParam int id,
                   @RequestParam String receipt) {

        for(Payment payment : paymentTable) {

            if(id == payment.id) {
                if(payment.history.get(payment.history.size() - 1).status == ON_PROGRESS && !receipt.isBlank()) {

                    Payment.Record newRecord = new Payment.Record(ON_DELIVERY, "on delivery");
                    payment.history.add(newRecord);
                    return true;

                }
            }
        }

        return false;

    }

    private static boolean timekeeper(Payment payment) {

        Payment.Record newestRecord = payment.history.get(payment.history.size() - 1);
        long timeElapsed = new Date().getTime() - newestRecord.date.getTime();
        return true;

    }
}
