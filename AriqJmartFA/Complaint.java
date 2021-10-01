package AriqJmartFA;

public class Complaint extends Recognizable implements FileParser {

    //public int paymentId;
    public String date;
    public String desc;
    
    public Complaint(int id, String desc) {

        super(id);
        this.date = "Date";
        this.desc = desc;


    }
    
    @Override
    public boolean read(String content) {

        return false;
    }
}
