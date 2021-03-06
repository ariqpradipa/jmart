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
                        if(prod.accountId == accountId && prod.name.equalsIgnoreCase(name)) {

                             return null;

                        }
                    }

                    Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlan, account.store.name);

                    getJsonTable().add(product);
                    return product;

                }
            }
        }

        return null;

    }

    @GetMapping(value = "/getAllProduct")
    public JsonTable<Product> getJsonTable() {

        return productTable;

    }

    @GetMapping(value ="/getProductList")
    List<Product> getProduct(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "9") int pageSize) {

        List<Product> result = new ArrayList<Product>();
        // int currIdx = page > 1 ? (page-1)*pageSize : 0;
        int i = 0, j = 0;
        int intercept = 0;

        while(i < getJsonTable().size() && j < pageSize) {
            if (page > 1 && intercept < pageSize * (page - 1)) {

                intercept++;
                i++;

                continue;

            }

            result.add(getJsonTable().get(i));
            j++;
            i++;


        }

        return result;

    }

    @GetMapping(value ="/{id}/store")
    List<Product> getProductByStore(@PathVariable int id,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "9") int pageSize) {

        List<Product> result = new ArrayList<Product>();
        // int currIdx = page > 1 ? (page-1)*pageSize : 0;
        int i = 0, j = 0;
        int intercept = 0;

        while(i < getJsonTable().size() && j < pageSize) {
            if (getJsonTable().get(i).accountId == id) {
                if (page > 1 && intercept < pageSize * (page - 1)) {

                    intercept++;
                    i++;

                    continue;

                }

                result.add(getJsonTable().get(i));
                j++;
                i++;

                continue;

            }

            i++;

        }

        return result;

    }

    @GetMapping(value="/getMaxPage")
    int getMaxPage(@RequestParam(defaultValue = "9") int pageSize) {

        int count = 0;
        int temp =0;
        for(Product prod : getJsonTable()) {
            temp++;
        }

        count = temp/pageSize;
        if(temp%pageSize != 0) {
            count += 1;
        }
        return count;
    }

    @GetMapping(value = "/getFiltered")
    List<Product> getProductFiltered(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "9") int pageSize,
                                     @RequestParam(defaultValue = "false") boolean usedStatus,
                                     @RequestParam String search,
                                     @RequestParam(defaultValue = "1000") int minPrice,
                                     @RequestParam(defaultValue = "100000") int maxPrice,
                                     @RequestParam ProductCategory category) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page - 1) * pageSize : 0;
        int i = 0, j = 0;
        int intercept = 0;

        while(i < getJsonTable().size() && j < pageSize) {
            if((getJsonTable().get(i).conditionUsed) == usedStatus) {
                if ((getJsonTable().get(i).name.toLowerCase()).contains(search.toLowerCase())) {
                    if (getJsonTable().get(i).price > minPrice && getJsonTable().get(i).price < maxPrice) {
                        if (getJsonTable().get(i).category.equals(category)) {
                            if (page > 1 && intercept < pageSize * (page - 1)) {

                                intercept++;
                                i++;
                                continue;
                            }

                            result.add(getJsonTable().get(i));
                            j++;
                            i++;

                            continue;

                        }
                    }
                }
            }

            i++;

        }

        return result;

    }
}
