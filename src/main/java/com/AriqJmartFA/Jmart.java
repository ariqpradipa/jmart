package com.AriqJmartFA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.AriqJmartFA.dbjson.JsonDBEngine;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

@SpringBootApplication

public class Jmart {

    public static void main(String[] args) {

        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

    }
}

    /*
    public static long DELIVERED_LIMIT_MS = 2;
    public static long ON_DELIVERY_LIMIT_MS = 4;
    public static long ON_PROGRESS_LIMIT_MS = 6;
    public static long WAITING_CONF_LIMIT_MS = 8;


    public static void main(String[] args) {

        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "src/db/randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-pp", Jmart::paymentTimeKeeper);
            paymentPool.start();
            table.forEach(paymentPool::add);
            while(paymentPool.size() != 0);
            paymentPool.exit();
            while(paymentPool.isAlive());
            System.out.println("Thread Exited Successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });

        } catch(Throwable t) {
            t.printStackTrace();
        }

    }

    public static boolean paymentTimeKeeper(Payment payment) {

        long startTime = new Date().getTime();
        long endTime = new Date().getTime();
        long timeElapsed = endTime - startTime;

        if(Payment.Record.status == Invoice.Status.WAITING_CONFIRMATION &&timeElapsed > WAITING_CONF_LIMIT_MS) {
            return false;
        }
        if(Payment.Record.status == Invoice.Status.ON_PROGRESS && timeElapsed > ON_PROGRESS_LIMIT_MS) {
            return false;
        }

        return true;

     */
    /*
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("Halo");
        list.add("Hi");
        list.add("Hola");
        list.add("Hai");
        list.add("NiHao");
        list.add("Ohayou");
        list.add("Buongiorno");
        list.add("Shalom");
        list.add("Ola");
        list.add("Ciao");
        list.add("Hei");

        System.out.println(list.size());

        for(String product : filterByName(list, "ha", 2, 2)) {
            System.out.println(product);
        }



        try {
            List<Product> list = read("src/db/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000, 15000);
            filtered.forEach(product -> System.out.println(product.price));
        } catch (Throwable t) {

            t.printStackTrace();

        }




        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        }
     */



    /*
    public static List<Product> read(String filePath) throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader(filePath));
        Product[] jsonProduct = new Gson().fromJson(reader, Product[].class);

        return new ArrayList<Product>(Arrays.asList(jsonProduct));

    }
    */

    /*
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < list.size() - currIdx; i++) {
            if(list.get(i).toString().contains(Integer.toString(accountId))) {

                result.add(list.get(i));

            }
        }

        return result;

    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {

        List<Product> filteredCategory = Algorithm.<Product>collect(list, prod -> prod.category == category);

        return filteredCategory;

    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < list.size() - currIdx; i++) {

            if(list.get(i).toString().toLowerCase().contains(search.toLowerCase())) {

                result.add(list.get(i));

            }
        }

        return result;

    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {

        List<Product> result = new ArrayList<Product>();

        for (Product product : list) {
            if(minPrice <= 0.0 && product.price <= minPrice) {
                continue;
            }
            if(maxPrice <= 0.0 && product.price >= maxPrice) {
                continue;
            }

            result.add(product);
        }

        return result;

    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < list.size() - currIdx; i++) {

            if(pred.predicate(list.get(i))) {

                result.add(list.get(i));

            }
        }

        return result;

    }
    */

    /*
    class Country {

        public String name;
        public int population;
        public List<String> listOfStates;

    }


    public static void main(String[] args) {



        String filepath = "src/db/city.json";
        Gson gson = new Gson();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(state -> System.out.println(state));

        }
        catch(IOException e) {
            e.printStackTrace();
        }



    }

     */


    /*
    public static Product createProduct() {

        PriceTag bookprice = new PriceTag(30000, 20);
        return new Product("LEGEND BOOK", 2, true, bookprice, ProductCategory.BOOK);
    }

    public static Coupon createCoupon() {

        return null;

    }

    public static ShipmentDuration createShipmentDuration() {

        return null;

    }
    */
