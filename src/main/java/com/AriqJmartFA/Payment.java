package com.AriqJmartFA;

import java.util.ArrayList;
import java.util.Date;

/**
 * Manage the payment of JMART transaction
 */
public class Payment extends Invoice {

    public ArrayList<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;

    /**
     * Creating new payment object.
     *
     * @param buyerId the buyer ID.
     * @param productId purchased product ID.
     * @param productCount purchased product Count.
     * @param shipment product shipment type.
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {

        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;

    }

    /**
     * Get the total pay form purchased product.
     *
     * @param product product object.
     * @return total price.
     */
    public static double getTotalPay(Product product) {

        return product.price;

    }

    /**
     * Record history list of payment.
     */
    public static class Record {

        public final Date date = new Date();
        public String message;
        public Status status;

        public Record(Status status, String message) {

            this.status = status;
            this.message = message;

        }
    }
}
