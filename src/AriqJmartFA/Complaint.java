package AriqJmartFA;

import java.util.Date;
import java.text.SimpleDateFormat;

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

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String deskripsi = this.desc;
        String tanggal = dateFormat.format(this.date);

        return ("date=" + tanggal + ", desc=" + deskripsi);
        
    }
    
    @Override
    public boolean read(String content) {

        return false;
    }
}
