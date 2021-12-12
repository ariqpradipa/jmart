package com.AriqJmartFA;

/**
 * Rating of product
 */
public class ProductRating {

    private long count;
    private long total;

    /**
     * current procuct rating
     */
    public ProductRating() {    

        this.total = 0;
        this.count = 0; 

    }

    /**
     *
     * @return average rating
     */
    public double getAverage() {

        if(this.count == 0) {

            return 0;

        } else {

            return this.total / this.count;

        }

    }

    /**
     *
     * @return rating count
     */
    public long getCount() {    

        return this.count;

    }

    /**
     *
     * @return total rating
     */
    public long getTotal() { 

        return this.total;

    }

    /**
     *
     * @param rating add new rating
     */
    public void insert(int rating) {

        this.total = this.total + rating;
        this.count++;

    }
}