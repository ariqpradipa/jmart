package AriqJmartFA;

import java.util.Date;

public class Invoice extends Recognizable implements FileParser {

    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    protected Invoice(int id, int buyerId, int productId) {

        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "Date";
        this.complaintId = -1;
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;

    }

    public boolean read(String content) {

        return false;

    }

    public double getTotalPay() {

        return 0;
        
    }

    public class Record {

        public Status status;
        public Date date;
        public String message;

    }

    public enum Status{

        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY,
        COMPLAINT, FINISHED, FAILED

    }

    public enum Rating {

        NONE, BAD, NEUTRAL, GOOD

    }
}
