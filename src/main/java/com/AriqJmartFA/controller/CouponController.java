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

public class CouponController implements BasicGetController<Coupon> {

    @JsonAutowired(filepath = "/json/Coupon.json", value = Coupon.class)
    public static JsonTable<Coupon> couponTable;

    @GetMapping(value ="{id}/canApply")
    boolean canApply(@RequestParam int id,
                     @RequestParam double price,
                     @RequestParam double discount) {

        for(Coupon coupon : getJsonTable()) {
            if(id == coupon.id) {

                return coupon.canApply(new Treasury());

            }
        }

        return false;

    }

    @GetMapping(value = "/getAvailable")
    List<Coupon> getAvailable(@RequestParam(defaultValue = "2") int page,
                              @RequestParam(defaultValue = "4") int pageSize) {

        return Algorithm.paginate(getJsonTable(), page, pageSize, object -> false);

    }

    public JsonTable<Coupon> getJsonTable() {

        return couponTable;

    }

    @GetMapping(value = "/{id}/isUsed")
    boolean isUsed(@RequestParam int id) {

        for(Coupon coupon : couponTable) {

            if(id == coupon.id) {

                return coupon.isUsed();

            }
        }

        return false;

    }
}
