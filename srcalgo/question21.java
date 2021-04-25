import java.util.*;
public class question21 {
    static int[] countingSort(int[] arr) {
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]> max){
                max = arr[i];
            }
        }
        int [] brr = new int[100];
        for(int i = 0;i<arr.length;i++){
            brr[arr[i]]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<brr.length;i++){
            for (int j = 0; j <brr[i]; j++) {
                result.add(i);
            }

        }
        int[] retArr = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            retArr[i] = result.get(i);
        }
        return retArr;
    }

}
