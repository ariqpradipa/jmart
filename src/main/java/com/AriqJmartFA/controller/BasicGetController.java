package com.AriqJmartFA.controller;
import com.AriqJmartFA.Algorithm;
import org.springframework.web.bind.annotation.*;
import com.AriqJmartFA.dbjson.Serializable;
import com.AriqJmartFA.dbjson.JsonTable;

import java.util.ArrayList;
import java.util.List;

public interface BasicGetController<T extends Serializable> {

    public default T getById(int id) {

        for(T object : getJsonTable()) {
            if(object.id == id) {
                return object;
            }
        }

        return null;

    }

    public abstract JsonTable<T> getJsonTable();


    public default List<T> getPage(int page, int pageSize) {

        return (List<T>) Algorithm.paginate(getJsonTable(), page, pageSize, object -> true);

    }
}
