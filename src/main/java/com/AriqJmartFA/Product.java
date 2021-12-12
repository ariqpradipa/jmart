package com.AriqJmartFA;

import com.AriqJmartFA.dbjson.Serializable;

/**
 * Product Object
 */
public class Product extends Serializable {

    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlan;
    public int weight;
    public String storeName;

    /**
     * Create new product object
     *
     * @param accountId seller account id
     * @param name product name
     * @param weight product weight in gram
     * @param conditionUsed new or used
     * @param price product price
     * @param discount product discount
     * @param category product category
     * @param shipmentPlan product shipment plan
     * @param storeName store name that sell product
     */
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlan, String storeName) {

        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlan = shipmentPlan;
        this.storeName = storeName;
        
    }

    /**
     * Show list of created product to string
     *
     * @return product object to string
     */
    public String toString() {

        String accID = "Account ID: " + this.accountId;
        String nama = "\nName: " + this.name;
        String berat = "\nWeight " + this.weight;
        String kondisi = "\nCondition: " + this.conditionUsed;
        String harga = "\nPrice: " + this.price;
        String diskon = "\nDiscount: " + this.discount;
        String kategori = "\nCategory: " + this.category;
        String shipPlan = "\nShipment Plan: " + this.shipmentPlan;

        return (accID + nama + berat + kondisi + harga + diskon + kategori + shipPlan);
        
        // return "Name: Harry Potter\nWeight: 1\nconditionUsed: false\npriceTag: 21000.0\ncategory: BOOK\nrating: 0\nstoreId: 1";

    }
}
