package com.AriqJmartFA.controller;

import com.AriqJmartFA.Product;
import com.AriqJmartFA.ProductCategory;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController {

    @JsonAutowired(filepath = "/json/Product.json", value = Product.class)
    public static JsonTable<Product> productTable;

    @PostMapping(value = "/create")
    Product create(@RequestParam int accountId,
                   @RequestParam String name,
                   @RequestParam int weight,
                   @RequestParam boolean conditionUsed,
                   @RequestParam double price,
                   @RequestParam double discount,
                   @RequestParam ProductCategory category,
                   @RequestParam byte shipmentPlan) {

        return null;


    }

    public JsonTable<Product> getJsonTable() {

        return productTable;

    }

    @GetMapping(value ="/{id}/store")
    List<Product> getProductByStore(@RequestParam int id,
                                    @RequestParam int page,
                                    @RequestParam int pageSize) {

        return null;



    }

    @GetMapping(value = "/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page,
                                     @RequestParam int pageSize,
                                     @RequestParam int accountId,
                                     @RequestParam String search,
                                     @RequestParam int minPrice,
                                     @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {

        return null;

    }


}
