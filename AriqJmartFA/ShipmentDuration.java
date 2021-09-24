package AriqJmartFA;


public class ShipmentDuration {
    
    public static ShipmentDuration INSTANT;
    public static ShipmentDuration SAME_DAY;
    public static ShipmentDuration NEXT_DAY;
    public static ShipmentDuration REGULER;
    public static ShipmentDuration KARGO;
    private int bit;
    
    private ShipmentDuration(int bit) {

        this.bit = bit;

    }

    public ShipmentDuration(ShipmentDuration ... args) {

        for(ShipmentDuration i: args) {

            if(i == INSTANT) {

                this.bit = this.bit | 1;

            }
            if(i == SAME_DAY) {

                this.bit = this.bit | 2;

            }
            if(i == NEXT_DAY) {

                this.bit = this.bit | 4;

            }
            if(i == REGULER) {

                this.bit = this.bit | 8;

            }
            if(i == KARGO) {

                this.bit = this.bit | 16;

            }
        }
    }

    public boolean isDuration(ShipmentDuration reference) {

        System.out.println("halo");
        return true;
        
        

    } 
    
}