import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question23 {

    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int minimumDiff = arr[1]-arr[0];
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        result.add(arr[1]);
        for (int i = 1; i <arr.length-1 ; i++) {
            if (arr[i+1]-arr[i]<minimumDiff){
                result = new ArrayList<>();
                result.add(arr[i]);
                result.add(arr[i+1]);
                minimumDiff = Math.abs(arr[i+1]-arr[i]);
            }
            else if (arr[i+1]-arr[i] == minimumDiff){
                result.add(arr[i]);
                result.add(arr[i+1]);
            }
        }
        int[] retArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            retArr[i] = result.get(i);
        }
        return retArr;
    }
    public static void main(String[] args) {

    }
}
