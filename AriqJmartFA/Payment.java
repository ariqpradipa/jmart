package AriqJmartFA;

public class Payment extends Invoice implements Transactor {
    
   
    public Shipment shipment;
    public int productCount;
    
    public Payment(int id, int buyerId, Product productId, int productCount, Shipment shipment) {
        
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        

    }

    public double getTotalPay() {

        return 0;
    }


    public boolean validate() {

        return false;

    }

    public Invoice perform() {

        return null;

    } 
}