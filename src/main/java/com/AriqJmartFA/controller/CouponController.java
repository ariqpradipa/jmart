package com.AriqJmartFA.controller;

import com.AriqJmartFA.Algorithm;
import com.AriqJmartFA.Coupon;
import com.AriqJmartFA.Treasury;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {

    @JsonAutowired(filepath = "json/Coupon.json", value = Coupon.class)
    public static JsonTable<Coupon> couponTable;

    @PostMapping("/create")
    Coupon create(@RequestParam String name,
                  @RequestParam int code,
                  @RequestParam Coupon.Type type,
                  @RequestParam double cut,
                  @RequestParam double minimum) {

        for(Coupon coupon : couponTable) {
            if(coupon.code != code) {
                if(!Objects.equals(coupon.name, name)) {

                    Coupon newCoupon = new Coupon(name, code, type, cut, minimum);
                    couponTable.add(newCoupon);
                    return newCoupon;

                }
            }
        }

        return null;

    }

    @GetMapping(value ="/{id}/canApply")
    boolean canApply(@PathVariable int id,
                     @RequestParam double price,
                     @RequestParam double discount) {

        for(Coupon coupon : getJsonTable()) {
            if(id == coupon.id) {

                return coupon.canApply(price, discount);

            }
        }

        return false;

    }

    @GetMapping(value = "/getAvailable")
    List<Coupon> getAvailable(@RequestParam(defaultValue = "2") int page,
                              @RequestParam(defaultValue = "4") int pageSize) {

        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> !pred.isUsed());

    }

    public JsonTable<Coupon> getJsonTable() {

        return couponTable;

    }

    @GetMapping(value = "/{id}/isUsed")
    boolean isUsed(@PathVariable int id) {

        for(Coupon coupon : couponTable) {

            if(id == coupon.id) {

                return coupon.isUsed();

            }
        }

        return false;

    }
}
