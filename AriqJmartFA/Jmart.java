package AriqJmartFA;

/**
 * praktikum oop
 *
 * @author Ariq Pradipa Santoso
 * @version 11/09/2021
 */

public class Jmart
{
    public static void main(String[] args) {


    }

    public static int getPromo() {

        return 0;

    }

    public static String getCustomer() {

        return "oop";

    }

    public static float getDiscountPercentage(int before, float after) {

        if(before < after) {

            return 0f;

        } else if(before == 0 && after == 0) {

            return 0f;

        } else{

            if(100f - ((after/(float)before)*100) == 0) {

                return 100f;

            } else {

                return 100f - ((after/(float)before)*100);

            }
        }
    }

    public static int getDiscountedPrice(int price, float discountPercentage) {

        if(discountPercentage > 100) {

            return 0;

        } else if(discountPercentage == 0 && price == 0) {

            return 0;

        } else {

            return (int)((float)price - ((float)price * discountPercentage/100));

        }
    }

    public static int getOriginalPrice(int discountPrice, float discountPercentage) {

        if(discountPrice < discountPercentage) {

            return 0;

        } else {

            return (int)(discountPrice * (100/(100-discountPercentage)));

        }
    }

    public static float getCommissionMultiplier() {

        return 0.05f;

    }
    
    public static int getAdjustedPrice(int price) {

        return price + (int)(price*0.05);

    }

    public static int getAdminFee(int price) {

        return (int)(price*0.05);

    }
}