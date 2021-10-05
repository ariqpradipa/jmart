package AriqJmartFA;

public class Product extends Recognizable implements FileParser {
    
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
   

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {

        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        
    }
    
    public boolean read(String content) {

        return false;

    }

    public String toString() {

        String nama = "Name: " + this.name;
        String berat = "\nWeight " + this.weight;
        String kondisi = "\nCondition: " + this.conditionUsed;
        String harga = "\nPriceTag: " + this.priceTag.price;
        String kategori = "\nCategory: " + this.category;
        String nilai = "\nRating: " + this.rating;
        String sid = "\nstoreId: " + this.storeId;

        StringBuilder strbld = new StringBuilder(nama)
        .append(berat)
        .append(kondisi)
        .append(harga)
        .append(kategori)
        .append(nilai)
        .append(sid);

        String str = strbld.toString();
        return str;
        
        // return "Name: Harry Potter\nWeight: 1\nconditionUsed: false\npriceTag: 21000.0\ncategory: BOOK\nrating: 0\nstoreId: 1";

    }
}
