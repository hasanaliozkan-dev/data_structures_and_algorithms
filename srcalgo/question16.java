import java.util.Arrays;

public class question16 {
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int result =0,i = 0,j=1;
        while(j<arr.length){
            if (arr[j]-arr[i] == k)
                result++;
            else if (arr[j]-arr[i]>k)
                i++;
            else
                j++;
        }
        return result;
    }




   /* This code gave me timeout error!!!
   static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (arr[i]-arr[j] == k){
                    result++;
                }
            }
        }

        return result;

    }*/
}
