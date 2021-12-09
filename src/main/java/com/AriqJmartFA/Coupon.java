package com.AriqJmartFA;

import com.AriqJmartFA.dbjson.Serializable;

public class Coupon extends Serializable {

    public final String name;
    public final int code;
    public final Type type;
    public final double cut;
    public final double minimum;
    private boolean used;

    /**
     * coupon for get reduction of product price
     *
     * @param name coupon name
     * @param code coupon code
     * @param type coupon type(disount or rebate)
     * @param cut coupon cut value
     * @param minimum minimum product price
     */
    public Coupon(String name, int code, Type type, double cut, double minimum) {

        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;

    }

    /**
     *
     *
     * @return cut of product price after coupon applied
     */
    public double apply(double price, double discount) {

        this.used = true;
        double adjustedPrice = Treasury.getAdjustedPrice(price, discount);

        switch(type) {
            case DISCOUNT: {
                if(cut >= 100.0) {
                    return 0.0;
                }

                return adjustedPrice - adjustedPrice*(cut/100);
            }
            case REBATE: {

                if(adjustedPrice <= cut) {

                    return 0;
                }

                return adjustedPrice - cut;

            }
        }

        return 0.0;
    }

    /**
     *
     * @param
     * @return boolean after product price meets coupon minimum
     */
    public boolean canApply(double price, double discount) {

        return !used && !(Treasury.getAdjustedPrice(price, discount) < minimum);
    }

    /**
     * check the coupon has been used or not
     *
     * @return boolean of coupon used
     */
    public boolean isUsed() {

        return this.used;

    }

    /**
     * coupon type, Dicount in percent, Rebate in number of cut
     */
    public static enum Type {

        DISCOUNT, REBATE

    }
}
