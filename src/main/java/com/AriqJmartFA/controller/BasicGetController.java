package com.AriqJmartFA.controller;
import com.AriqJmartFA.Account;
import com.AriqJmartFA.Algorithm;
import org.springframework.web.bind.annotation.*;
import com.AriqJmartFA.dbjson.Serializable;
import com.AriqJmartFA.dbjson.JsonTable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/controller")
public interface BasicGetController<T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {

        for(T object : getJsonTable()) {

            if(object.id == id) {

                return object;

            }
        }

        return null;

    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping(value ="/page")
    public default List<T> getPage(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "9") int pageSize) {

        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);

    }
}
