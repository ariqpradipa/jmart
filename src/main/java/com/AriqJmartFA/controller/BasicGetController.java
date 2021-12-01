package com.AriqJmartFA.controller;
import com.AriqJmartFA.Algorithm;
import org.springframework.web.bind.annotation.*;
import com.AriqJmartFA.dbjson.Serializable;
import com.AriqJmartFA.dbjson.JsonTable;

import java.util.ArrayList;
import java.util.List;

public interface BasicGetController<T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById(@RequestParam int id) {

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
                                   @RequestParam(defaultValue = "5") int pageSize) {

        return Algorithm.paginate(getJsonTable(), page, pageSize, object -> true);

    }
}
