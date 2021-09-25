package AriqJmartFA;



public class Complaint extends Recognizeable implements FileParser {

    public int paymentId;
    public String desc;
    /*
    public Complaint(int id, Payment payment, String desc) {

        super(id);
        this.paymentId = payment.id;
        this.desc = desc;
    
    }
    */
    
    public Complaint(int id, int buyerId, int scoreId, int paymentId, String desc) {

        super(id);
        //super(buyerId);
        
        this.paymentId = paymentId;
        this.desc = desc;


    }

    public boolean validate() {

        return false;
    }
    
    public Transaction perform() {

        return null;

    }

    public boolean read(String content) {

        return false;
    }
}
