package AriqJmartFA;

import java.util.ArrayList;

public class Filter {
    
    public ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {

        ArrayList<PriceTag> temp = new ArrayList<PriceTag>();

        for(int i=0; i<list.length; i++) {

            if(less == true) {

                temp.add(list[i]);
    
            }
            else if(less = false) {

            }
        }
        

        return temp;
    }

    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {

        for(int i=0; i<list.size(); i++) {

            if(less == true) {
                //if( < value) {}
            }

        }
    }
}
