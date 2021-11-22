package com.AriqJmartFA.controller;

import com.AriqJmartFA.Coupon;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CouponController implements BasicGetController<Coupon> {

    public static JsonTable couponTable;
    /*
    @RequestMapping(value ="{id}/canApply", method = RequestMethod.GET)
    boolean canApply(@RequestParam int id,
                     @RequestParam double price,
                     @RequestParam double discount) {

        return false;

    }
    */


    @RequestMapping(value = "/getAvailable", method = RequestMethod.GET)
    List<Coupon> getAvailable(@RequestParam(defaultValue = "2") int page,
                              @RequestParam(defaultValue = "4") int pageSize) {

        return null;

    }

    public JsonTable<Coupon> getJsonTable() {

        return couponTable;

    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@RequestParam int id) {

        return false;

    }



}
