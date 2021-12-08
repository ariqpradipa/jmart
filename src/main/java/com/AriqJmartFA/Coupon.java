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
     * @param priceTag pricetag value
     * @return cut of product price after coupon applied
     */
    public double apply(Treasury priceTag) {

        this.used = true;

        if(this.type == Type.DISCOUNT) {

            return priceTag.getAdjustedPrice(this.minimum, this.cut) - (priceTag.getAdjustedPrice(this.minimum, this.cut) * (cut/100)); // skala discount 1-100

        } else {

            return priceTag.getAdjustedPrice(this.minimum, this.cut) - cut;

        }
    }

    /**
     *
     * @param priceTag pricetag value
     * @return boolean after product price meets coupon minimum
     */
    public boolean canApply(Treasury priceTag) {

        return (priceTag.getAdjustedPrice(this.minimum, this.cut) >= this.minimum && !this.used);
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
