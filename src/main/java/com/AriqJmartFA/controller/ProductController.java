package com.AriqJmartFA.controller;

import com.AriqJmartFA.*;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.AriqJmartFA.controller.AccountController.accountTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController {

    @JsonAutowired(filepath = "src/main/resources/json/Product.json", value = Product.class)
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
                                    @RequestParam int page,
                                    @RequestParam int pageSize) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < getJsonTable().size() - currIdx; i++) {
            if(getJsonTable().get(i).toString().contains(Integer.toString(id))) {

                result.add(getJsonTable().get(i));

            }
        }

        return result;

        /*
        for(Product product : getJsonTable()) {
            if(product.accountId == id) {

                return Algorithm.paginate(getJsonTable(), page, pageSize, object -> true);

            }
        }

        return null;
        */

    }

    @GetMapping(value = "/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page,
                                     @RequestParam int pageSize,
                                     @RequestParam int accountId,
                                     @RequestParam String search,
                                     @RequestParam int minPrice,
                                     @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < getJsonTable().size() - currIdx; i++) {

            if(getJsonTable().get(i).toString().toLowerCase().contains(search.toLowerCase()) ||
                    getJsonTable().get(i).toString().contains(Integer.toString(accountId)) ||
                    ((minPrice > 0 && getJsonTable().get(i).price >= minPrice) && (maxPrice > minPrice && getJsonTable().get(i).price <= maxPrice))) {

                result.add(getJsonTable().get(i));

            }
        }

        List<Product> filteredCategory = Algorithm.<Product>collect(getJsonTable(), prod -> prod.category == category);

        for(Product e : filteredCategory) {

            if(!result.contains(e)) {

                result.add(e);

            }
        }

        return result;

    }
}
