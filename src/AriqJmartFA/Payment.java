package AriqJmartFA;

public class Payment extends Invoice {
    
   
    public Shipment shipment;
    public int productCount;
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment) {
        
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        

    }

    public double getTotalPay() {

        return 0;

    }

    public Invoice perform() {

        return null;

    } 
}
