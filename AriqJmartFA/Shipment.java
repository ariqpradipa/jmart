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
        
        
        public static Duration INSTANT = new Duration((byte)(0b00000001));
        public static Duration SAME_DAY = new Duration((byte)(0b00000010));
        public static Duration NEXT_DAY = new Duration((byte)(0b00000100));
        public static Duration REGULER = new Duration((byte)(0b00001000));
        public static Duration KARGO = new Duration((byte)(0b00010000));
        private byte bit;
        
        private Duration(byte bit) {
    
            this.bit = bit;
    
        }
    }

    
    public class MultiDuration {

        public byte bit;

        
        public MultiDuration(Duration ... args) {

            byte flags = 0;

            for(int i = 0; i < args.length; i++) {

                flags |= args[i].bit;

            }

            bit = flags;
              
        }
        
        
        public boolean isDuration(Duration reference) {
    
            return (bit & reference.bit) != 0;
    
        } 
    }
}
