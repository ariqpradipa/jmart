package AriqJmartFA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.ArrayList;

/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

public class Jmart {

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {

        List<Product> filteredCategory = Algorithm.<Product>collect(list, prod -> prod.category == category);

        return filteredCategory;

    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {

        List<Product> result = new ArrayList<Product>();

        for (Product product : list) {
            if(minPrice <= 0.0 && product.price < minPrice) {
                continue;
            }
            if(maxPrice <= 0.0 && product.price > maxPrice) {
                continue;
            }

            result.add(product);
        }

        return result;

    }

    public static void main(String[] args) {


        /*
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        */

    }

    public static List<Product> read(String filePath) throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader("src/db/randomProductList.json"));
        Product[] jsonProduct = new Gson().fromJson(reader, Product[].class);

        List<Product> result = new ArrayList<Product>();
        for(Product product : jsonProduct) {
            result.add(product);
        }

        return result;

    }


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
}