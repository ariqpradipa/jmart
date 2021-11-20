// TODO sesuaikan dengan package Anda: package com.alvinJmartRK.controller;
package com.AriqJmartFA.controller;

// TODO sesuaikan dengan package Anda: import com.alvinJmartRK.Account;
import com.AriqJmartFA.Algorithm;
import com.AriqJmartFA.Store;
import com.AriqJmartFA.dbjson.JsonAutowired;
import com.AriqJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.AriqJmartFA.Account;

import java.io.IOException;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {

    public static final String REGEX_EMAIL = "(?:[A-Za-z0-9&_*~]+(?:\\.[A-Za-z0-9&_*~]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[A-Za-z0-9-]*[A-Za-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    public static final String REGEX_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?!.*?[\\s]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {

        return accountTable;

    }

    @PostMapping("/login")
    Account login(String email, String password) {

        for(Account account : getJsonTable()) {
            if(account.email == email && account.password == password) {

                return account;

            }
        }

        return null;

    }

    @PostMapping("/register")
    Account register (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {

        if(name.isBlank() || !REGEX_PATTERN_EMAIL.matcher(email).matches()) {

            return null;

        } else if(!REGEX_PATTERN_PASSWORD.matcher(password).matches()){
            return null;

        } else {

            Account account = new Account(name, email, password, 0);
            accountTable.add(account);
            return account;

        }
    }

    @PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber) {

        for(Account account : accountTable) {
            if(account.id == id && account.store == null) {

                Store store = new Store(name, address, phoneNumber, 0);
                account.store = store;
                return store;

            }
        }

        return null;

    }

    boolean topUp(int id, double balance) {

        for(Account account : accountTable) {
            if(account.id == id) {
                account.balance += balance;
                return true;
            }
        }

        return false;

    }
}
