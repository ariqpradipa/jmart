package com.AriqJmartFA.controller;

import com.AriqJmartFA.ObjectPoolThread;
import com.AriqJmartFA.Payment;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 2;
    public static final long ON_DELIVERY_LIMIT_MS = 3;
    public static final long ON_PROGRESS_LIMIT_MS = 4;
    public static final long WAITING_CONF_LIMIT_MS = 5;
    public static JsonTable<Payment> paymentTable;

    static {

        ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread-pp", PaymentController::timekeeper);

    }

    @PostMapping("/{id}/accept")
    boolean accept(int id) {
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(int id) {
        return false;
    }

    @PostMapping("/create")
    Payment create(int buyerId, int productId, int productCount, String ShipmentDuration, String shipmentPlan) {
        return null;
    }

    public JsonTable getJsonTable() {

        return paymentTable;

    }

    @PostMapping("/{id}/submit")
    boolean submit(int id, String receipt) {

        return false;

    }

    private static boolean timekeeper(Payment payment) {

        return false;

    }
}
