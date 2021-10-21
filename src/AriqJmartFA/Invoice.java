package AriqJmartFA;

import java.util.ArrayList;
import java.util.Date;

public class Invoice extends Recognizable {

    public int buyerId;
    public int complaintId;
    public String date;
    ArrayList<Record> history;
    public int productId;
    public Rating rating;
    public Status status;

    protected Invoice(int buyerId, int productId) {

        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "Date";
        this.complaintId = -1;
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;

    }

    double getTotalPay() {

        return 0;

    }

    public static enum Status{

        CANCELLED, COMPLAINT, FAILED, FINISHED, ON_DELIVERY,
        ON_PROGRESS, WAITING_CONFIRMATION

    }

    public static enum Rating {

        BAD, GOOD, NEUTRAL, NONE

    }

    public class Record {

        public Date date;
        public String message;
        public Status status;

    }
}
