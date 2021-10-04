package AriqJmartFA;

import java.util.Date;
import java.util.Calendar;

public class Complaint extends Recognizable implements FileParser {

    //public int paymentId;
    Date date;
    public String desc;
    
    public Complaint(int id, String desc) {

        super(id);
        this.date = new Date();
        this.desc = desc;


    }

    public String toString() {
        this.desc = "pengiriman tidak cepat, kurir tersesat";
        return desc;
        
    }
    
    @Override
    public boolean read(String content) {

        return false;
    }
}
