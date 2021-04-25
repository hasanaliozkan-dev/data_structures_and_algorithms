import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question22 {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            int temp = arr[i];
            int k;
            for(k = i;k>0 && temp<arr[k-1];k--){
                arr[k] = arr[k-1];
            }
            arr[k]=temp;

        }
        return arr;
    }
    static int findMedian(int[] arr) {
        arr = insertionSort(arr);
        return arr[(arr.length/2)];

    }

    public static void main(String[] args) {
        int[] myArr = {0,1,2,4,6,5,3};
        int[] sortedArr = insertionSort(myArr);
        System.out.println(Arrays.toString(sortedArr));;
    }
}
