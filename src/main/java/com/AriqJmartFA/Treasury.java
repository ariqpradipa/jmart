package com.AriqJmartFA;

public class Treasury {

    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;

    /**
     * adjust price after disocunt and add admin fee
     *
     * @param price product price
     * @param discount product discounr
     * @return
     */
    public static double getAdjustedPrice(double price, double discount) {

        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);

    }

    /**
     * admin fee for payment
     *
     * @param price product price
     * @param discount product disount
     * @return
     */
    public static double getAdminFee(double price, double discount) {

        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE) {

            return BOTTOM_FEE;

        } else {

            return (getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER);

        }
    }

    /**
     * discounted price
     *
     * @param price product price
     * @param discount product discount
     * @return
     */
    public static double getDiscountedPrice(double price, double discount) {

        if(discount >= 100) {

            return 0;

        } else {

            return price - (price * discount);

        }
    }
}
