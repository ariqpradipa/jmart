package AriqJmartFA;

import AriqJmartFA.Invoice.Rating;

public class Product extends Recognizeable implements FileParser {
    
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public Rating rating;
    //public MultiDuration multiDuration;
   

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {

        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;

    }
    
    public boolean read(String content) {

        return false;

    }

    public String toString() {

        /*
        this.name = "Harry Potter";
        this.weight = 1;
        this.conditionUsed = false;
        this.priceTag.price = 21000.0;
        this.category = ProductCategory.BOOK;
        this.rating = Rating.NONE;
        this.storeId = 1;
        */

        return "Name: Harry Potter\nWeight: 1\nconditionUsed: false\npriceTag: 21000.0\ncategory: BOOK\nrating: 0\nstoreId: 1";

    }


}
