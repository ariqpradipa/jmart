package com.AriqJmartFA;

/**
 * For topup by phone number
 */
public class PhoneTopUp extends Invoice {

    public String phoneNumber;
    public Status status;

    /**
     * topup object
     * @param buyerId the buyer ID
     * @param productId product ID
     * @param phoneNumber user phone number
     */
    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {

        super(buyerId, productId);
        this.phoneNumber = phoneNumber;

    }

    /**
     * Get total pay from topup
     *
     * @param product the product
     * @return return get total pay
     */
    public double getTotalPay(Product product) {

        return 0;

    }
}
