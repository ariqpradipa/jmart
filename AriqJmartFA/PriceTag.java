package AriqJmartFA;

public class PriceTag {

    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;
    public double discount;
    public double price;
    
    public PriceTag(double price) {

        this.price = price;

    }

    public PriceTag(double price, double discount) {

        this.price = price;
        this.discount = discount;

    }

    public double getAdjustedPrice() {

        return getDiscountedPrice() + getAdminFee();

    }

    public double getAdminFee() {

        if(getDiscountedPrice() < BOTTOM_PRICE) {

            return BOTTOM_FEE;

        } else {

            return getDiscountedPrice() - (getDiscountedPrice() * COMMISSION_MULTIPLIER);

        }
    }

    private double getDiscountedPrice() {

        if(this.discount >= 100) {

            return 0;

        } else {

            return this.price - (this.price * this.discount);

        }
    }
}
