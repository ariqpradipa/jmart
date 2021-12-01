package com.AriqJmartFA.controller;

import com.AriqJmartFA.*;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.AriqJmartFA.controller.AccountController.accountTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController {

    @JsonAutowired(filepath = "json/Product.json", value = Product.class)
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

        for(Account account : accountTable) {

            if(accountId == account.id) {
                if(account.store != null) {
                    for(Product prod : productTable) {
                        if(prod.name.equals(name)) {

                             return null;

                        }
                    }

                    Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlan);

                    getJsonTable().add(product);
                    return product;

                }
            }
        }

        return null;

    }

    public JsonTable<Product> getJsonTable() {

        return productTable;

    }

    @GetMapping(value ="/{id}/store")
    List<Product> getProductByStore(@RequestParam int id,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "5") int pageSize) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(Product prod : productTable) {
            if(prod.id == currIdx) {
                for(int i = currIdx; (i - currIdx) < pageSize && i < getJsonTable().size(); i++) {
                    if (getJsonTable().get(i).accountId == id) {

                        result.add(getJsonTable().get(i));

                    }
                }

                return result;

            }
        }

        return null;
    }

    @GetMapping(value = "/getFiltered")
    List<Product> getProductFiltered(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "5") int pageSize,
                                     @RequestParam int accountId,
                                     @RequestParam String search,
                                     @RequestParam int minPrice,
                                     @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page - 1) * pageSize : 0;

        for (Product prod : productTable) {
            if (prod.id == currIdx) {
                for (int i = currIdx; (i - currIdx) < pageSize && i < getJsonTable().size(); i++) {
                    if (getJsonTable().get(i).accountId == accountId) {
                        if ((getJsonTable().get(i).name).equalsIgnoreCase(search)) {
                            if (getJsonTable().get(i).price > minPrice && getJsonTable().get(i).price < maxPrice) {
                                if (getJsonTable().get(i).category.equals(category)) {

                                    result.add(getJsonTable().get(i));

                                }
                            }
                        }
                    }
                }

                return result;

            }
        }

        return null;

    }
}
