package AriqJmartFA;


public class Shipment implements FileParser {

    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;

    public Shipment(String address, int ShipmentCost, Duration duration, String receipt) {

        this.address = address;
        this.shipmentCost = ShipmentCost;
        this.duration = duration;
        this.receipt = receipt;

    }

    @Override
    public boolean read(String content) {
        
        return false;

    }

    
    public static class Duration {
        
        
        public static Duration INSTANT = new Duration((byte)(1<<0));
        public static Duration SAME_DAY = new Duration((byte)(1<<1));
        public static Duration NEXT_DAY = new Duration((byte)(1<<2));
        public static Duration REGULER = new Duration((byte)(1<<3));
        public static Duration KARGO = new Duration((byte)(1<<4));
        private byte bit;
        
        private Duration(byte bit) {
    
            this.bit = bit;
    
        }
    }

    public class MultiDuration {

        public final byte bit;

        public MultiDuration(Duration ... args) {
    
            for(Duration i: args) {
    
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
    
            Integer.toBinaryString(this.bit);
            
            ShipmentDuration.INSTANT = true;
    
        } 

    }
    
    
}
