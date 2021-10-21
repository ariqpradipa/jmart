package AriqJmartFA;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable {

    Date date;
    public String desc;
    
    public Complaint(String desc) {

        this.date = new Date();
        this.desc = desc;

    }

    public String toString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String deskripsi = this.desc;
        String tanggal = dateFormat.format(this.date);

        return ("date=" + tanggal + ", desc=" + deskripsi);
        
    }
}
