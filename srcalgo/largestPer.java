import java.util.*;

public class largestPer {
   static int[] largestPermutation(int k, int[] arr) {
       int len = arr.length;
        for (int i = 0; i <len &&k>0; i++) {
            int max= 0;
            int j = 0;
            while (j<len){
                if (arr[j] == len-i){
                    max = j;
                    break;
                }
                j++;
            }
            /*for (j = 0; j <arr.length ; j++) {
                if (arr[j]==arr.length-i){
                    index =j;
                    break;
                }
            }*/
            if (i == max) continue;
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            k--;
        }
        return arr;
    }


    /*
    * static int[] largestPermutation(int k, int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] != n - i && k != 0){
                int j = i + 1;
                while(arr[j] != n - i){
                    j++;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                k--;
            }
        }
        return arr;
    }*/
    public static void main(String[] args) {

        int[] arr = {4,2,3,5,1};
        System.out.println(Arrays.toString(
                largestPermutation(90, arr)).replace('[',' ')
                .replace(']',' ')
                .replace(',',' '));;
    }
}
