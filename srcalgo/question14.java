import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class question14 {
    //medium
    static int minimumLoss(long[] price) {
        LinkedList<Long> prices = new LinkedList<>();
        for (int i = 0; i <price.length ; i++) {
            prices.add(price[i]);
        }

        Arrays.sort(price);
        long minimaldifference = Long.MAX_VALUE;
        for (int i = prices.size()-1, j = prices.size()-2; i>0 && j>=0 ; i--,j--) {
            Long difference  = price[i]-price[j];
            if (difference<minimaldifference && prices.indexOf(price[j])>prices.indexOf(price[i]))
                minimaldifference = difference;
        }
        return (int)minimaldifference;
    }

    public static void main(String[] args) {

    }
    /*long[] pricePlusIndex = new long[price.length];
        for (int i = 0; i <price.length; i++) {
            pricePlusIndex[i] = i + price[i];
        }
        Arrays.sort(price);
        for (int i = price.length-1,j = price.length-2; i >0 && j >=0 ; i--,j--) {
            int difference = (int)(price[i]-price[j]);
            if(pricePlusIndex[i]-price[i]> pricePlusIndex[j] -price[j]){
                if(difference<minimaldifference)
                    minimaldifference = difference;
            }

        }*/

}
