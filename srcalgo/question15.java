import java.util.Arrays;
import java.util.LinkedList;

public class question15 {

    static int runningTime(int[] arr) {
        int shiftNumbers = 0;
        for (int i = 1; i <arr.length ; i++) {
            int temp = arr[i];
            int j =i;
            while (j>=1 && arr[j-1]> temp){
                arr[j] = arr[j-1];
                shiftNumbers++;
                j--;
            }
            arr[j] = temp;
        }
        return shiftNumbers;
    }
    static void insertionSort1(int n, int[] arr) {
        int number = arr[n-1];
        for(int i = n-2;i>=0;i--){
            if (arr[i]> number){
                arr[i+1] = arr[i];
            }
            if (arr[i]< number){
                arr[i+1] = number;
                break;
            }
            for (int num:arr) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
        if (arr[0]>number){

            arr[0] = number;

        }
        for (int num:arr) {
            System.out.print(num+" ");
        }
        System.out.println();

    }
    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i <n ; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j>=1 && arr[j-1] > temp ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
            for (int number:arr) {
                System.out.print(number +"");
            }
            System.out.println();

        }
    }


}
