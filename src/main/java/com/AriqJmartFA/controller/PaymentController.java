package com.AriqJmartFA.controller;

import com.AriqJmartFA.ObjectPoolThread;
import com.AriqJmartFA.Payment;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 2;
    public static final long ON_DELIVERY_LIMIT_MS = 3;
    public static final long ON_PROGRESS_LIMIT_MS = 4;
    public static final long WAITING_CONF_LIMIT_MS = 5;

    @JsonAutowired(filepath = "/json/Payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    static {

        ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread-pp", PaymentController::timekeeper);

    }

    @PostMapping("/{id}/accept")
    boolean accept(@RequestParam int id) {

        return true;

    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@RequestParam int id) {

        return true;

    }

    @PostMapping("/create")
    Payment create(@RequestParam int buyerId,
                   @RequestParam int productId,
                   @RequestParam int productCount,
                   @RequestParam String ShipmentDuration,
                   @RequestParam String shipmentPlan) {

        return null;

    }

    public JsonTable getJsonTable() {

        return paymentTable;

    }

    @PostMapping("/{id}/submit")
    boolean submit(@RequestParam int id,
                   @RequestParam String receipt) {

        return false;

    }

    private static boolean timekeeper(Payment payment) {

        Payment.Record newestRecord = payment.history.get(payment.history.size() - 1);
        long timeElapsed = new Date().getTime() - newestRecord.date.getTime();
        return true;

    }
}
