package com.AriqJmartFA.controller;

import com.AriqJmartFA.ObjectPoolThread;
import com.AriqJmartFA.Payment;
import com.AriqJmartFA.dbjson.JsonTable;

public class PaymentController {
    public static final long DELIVERED_LIMIT_MS = 2;
    public static final long ON_DELIVERY_LIMIT_MS = 3;
    public static final long ON_PROGRESS_LIMIT_MS = 4;
    public static final long WAITING_CONF_LIMIT_MS = 5;
    public static JsonTable<Payment> paymentTable;
    ObjectPoolThread<Payment> poolThread;

    boolean accept(int id) {
        return false;
    }

    boolean cancel(int id) {
        return false;
    }

    Payment create(int buyerId, int productId, int productCount, String ShipmentDuration, String shipmentPlan) {
        return null;
    }

    public JsonTable getJsonTable() {

        return null;

    }

    boolean submit(int id, String receipt) {

        return false;

    }

    private static boolean timekeeper(Payment payment) {

        return false;

    }

}
