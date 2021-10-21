package AriqJmartFA;

public class ProductRating {

    private long count;
    private long total;

    public ProductRating() {    

        this.total = 0;
        this.count = 0; 

    }

    public double getAverage() {

        if(this.count == 0) {

            return 0;

        } else {

            return this.total / this.count;

        }

    }   

    public long getCount() {    

        return this.count;

    }   

    public long getTotal() { 

        return this.total;

    }

    public void insert(int rating) {

        this.total = this.total + rating;
        this.count++;

    }
}