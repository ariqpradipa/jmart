package com.AriqJmartFA.controller;

import com.AriqJmartFA.Product;
import com.AriqJmartFA.ProductCategory;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController {

    public static JsonTable<Product> productTable;

    /*
    @RequestMapping("/create")
    Product create(@RequestParam int accountId,
                   @RequestParam String name,
                   @RequestParam int weight,
                   @RequestParam boolean conditionUsed,
                   @RequestParam double price,
                   @RequestParam double discount,
                   @RequestParam ProductCategory category,
                   @RequestParam byte shipmentPlan) {


    }
    */

    //@JsonAutowired(Product.class, filepath = "product.json")
    public JsonTable<Product> getJsonTable() {

        return productTable;

    }

    /*
    @RequestMapping("/{id}/store")
    List<Product> getProductByStore(@RequestParam int id,
                                    @RequestParam int page,
                                    @RequestParam int pageSize) {



    }

    @RequestMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page,
                                     @RequestParam int pageSize,
                                     @RequestParam int accountId,
                                     @RequestParam String search,
                                     @RequestParam int minPrice,
                                     @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {

    }
    */

}
