package com.AriqJmartFA;

public class Treasury {

    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;

    public double getAdjustedPrice(double price, double discount) {

        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);

    }

    public double getAdminFee(double price, double discount) {

        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE) {

            return BOTTOM_FEE;

        } else {

            return (getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER);

        }
    }

    public double getDiscountedPrice(double price, double discount) {

        if(discount >= 100) {

            return 0;

        } else {

            return price - (price * discount);

        }
    }
}
