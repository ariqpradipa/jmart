package com.AriqJmartFA;

import com.AriqJmartFA.dbjson.Serializable;

import java.util.Date;

public class Invoice extends Serializable {

    public int buyerId;
    public int complaintId;
    public Date date;
    public int productId;
    public Rating rating;

    /**
     * Invoice after buyer make a payment
     *
     * @param buyerId the buyer ID
     * @param productId the product ID
     */
    protected Invoice(int buyerId, int productId) {

        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.date = new Date();
        this.rating = Rating.NONE;

    }

    /**
     * total pay of product
     *
     * @return the total pay
     */
    double getTotalPay() {

        return 0;

    }

    /**
     * product progress
     */
    public static enum Status{

        CANCELLED, COMPLAINT, FAILED, FINISHED, ON_DELIVERY,
        ON_PROGRESS, WAITING_CONFIRMATION

    }

    /**
     * for product rating
     */
    public static enum Rating {

        BAD, GOOD, NEUTRAL, NONE

    }

}
