package AriqJmartFA;

public class Coupon extends Recognizeable implements FileParser{

    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum) {

        super(id);
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

        if(priceTag.getAdjustedPrice() >= this.minimum && this.used == false) {

            return true;

        }  else {

            return false;
        }
    }

    public double apply(PriceTag priceTag) {

        this.used = true;

        if(this.type == Type.DISCOUNT) {

            return priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() * (cut/100)); // skala discount 1-100

        } else {

            return priceTag.getAdjustedPrice() - cut;

        }
    }

    @Override
    public boolean read(String content) {
       
        return false;
        
    }
}
