package AriqJmartFA;


public class ShipmentDuration {
    
    public static ShipmentDuration INSTANT;
    public static ShipmentDuration SAME_DAY ;
    public static ShipmentDuration NEXT_DAY;
    public static ShipmentDuration REGULER;
    public static ShipmentDuration KARGO;
    private final int bit;

    private ShipmentDuration(int bit) {

        this.bit = bit;

    }

    public ShipmentDuration(ShipmentDuration ... args) {

        
        



    }

    public boolean isDuration(ShipmentDuration reference) {

        

    }
}
