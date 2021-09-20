package AriqJmartFA;

public class Coupon {

    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;

    public Coupon(String name, int code, Type type, double cut, double minimum) {

        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;


    }

    public boolean isUsed() {

        return this.used;

    }

    public boolean canApply(PriceTag priceTag) {

        if(PriceTag.getAdjustedPrice() >= this.minimum && this.used == false) {

            return true;

        }  else {

            return false;
        }
    }

    public double apply(PriceTag priceTag) {

        this.used = true;

        return getAdjustedPrice()
    }
   
}
