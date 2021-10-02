package AriqJmartFA;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

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
        
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
        public static Duration INSTANT = new Duration((byte)(0b00000001));
        public static Duration SAME_DAY = new Duration((byte)(0b00000010));
        public static Duration NEXT_DAY = new Duration((byte)(0b00000100));
        public static Duration REGULER = new Duration((byte)(0b00001000));
        public static Duration KARGO = new Duration((byte)(0b00010000));
        private byte bit;
        
        private Duration(byte bit) {
    
            this.bit = bit;
    
        }

        public String getEstimatedArrival(Date reference) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(reference);
            String strDate;

            if(bit == 0b00000001 && bit == 0b00000010) {

                strDate = ESTIMATION_FORMAT.format(cal.getTime());
                return strDate;

            }
            else if(bit == 0b00000100) {

                cal.add(Calendar.DATE, 1);
                strDate = ESTIMATION_FORMAT.format(cal.getTime());
                return strDate;
            }
            else if(bit == 0b00001000) {

                cal.add(Calendar.DATE, 2);
                strDate = ESTIMATION_FORMAT.format(cal.getTime());
                return (cal.getTime().toString());
                
            }
            else if(bit == 0b00010000) {

                cal.add(Calendar.DATE, 3);
                strDate = ESTIMATION_FORMAT.format(cal.getTime());
                return (cal.getTime().toString());

            }
            else {

                return null;
                
            }
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
