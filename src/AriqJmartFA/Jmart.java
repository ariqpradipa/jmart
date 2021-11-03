package AriqJmartFA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

public class Jmart {

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