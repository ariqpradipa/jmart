package AriqJmartFA;

public class Complaint extends Recognizeable implements FileParser {

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
    /*
    public Complaint(int id, Payment payment, String desc) {

        super(id, null, null);
        this.paymentId = payment.id;
        this.desc = desc;
    
    }
    
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {

        super(id, buyerId, storeId);
        this.paymentId = paymentId;
        this.desc = desc;


    }

    public boolean validate() {

        return false;
    }
    
    public Transaction perform() {

        return null;

    }
    */
}
