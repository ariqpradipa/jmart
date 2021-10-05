package AriqJmartFA;

import java.util.ArrayList;

// filter things
public class Filter {
    
    public ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {

        ArrayList<PriceTag> temp = new ArrayList<PriceTag>();

        for (PriceTag priceTag : list) {

            if (less) {

                if (priceTag.getAdjustedPrice() < value) {

                    temp.add(priceTag);

                }
            } else {

                if (priceTag.getAdjustedPrice() >= value) {

                    temp.add(priceTag);

                }
            }
        }
        
        return temp;

    }

    public void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {

        for(int i=0; i<list.size(); i++) {

            if(less) {
                if(list.get(i).getAverage() < value) {

                    list.remove(i);

                }
            }
            else {
                if(list.get(i).getAverage() >= value) {

                    list.remove(i);

                }
            }
        }
    }
}
