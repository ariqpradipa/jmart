package AriqJmartFA;

/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

public class Jmart
{
    public static void main(String[] args) {
        

    }

    public static Product createProduct() {

        PriceTag bookprice = new PriceTag(30000, 20);
        return new Product("LEGEND BOOK", 2, true, bookprice, ProductCategory.BOOK);
    }

    public static Coupon createCoupon() {

        return null;

    }

    public static ShipmentDuration createShipmentDuration() {

        return null;

    }
}