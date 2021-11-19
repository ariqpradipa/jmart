package com.AriqJmartFA;

public class Coupon extends Serializable {

    public final int code;
    public final double cut;
    public final double minimum;
    public final String name;
    public final Type type;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum) {

        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;

    }

    public double apply(Treasury priceTag) {

        this.used = true;

        if(this.type == Type.DISCOUNT) {

            return priceTag.getAdjustedPrice(this.minimum, this.cut) - (priceTag.getAdjustedPrice(this.minimum, this.cut) * (cut/100)); // skala discount 1-100

        } else {

            return priceTag.getAdjustedPrice(this.minimum, this.cut) - cut;

        }
    }

    public boolean canApply(Treasury priceTag) {

        return (priceTag.getAdjustedPrice(this.minimum, this.cut) >= this.minimum && !this.used);
    }

    public boolean isUsed() {

        return this.used;

    }

    public static enum Type {

        DISCOUNT, REBATE

    }
}
