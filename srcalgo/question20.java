public class question20 {
    static int[] quickSort(int[] arr) {
        int pivot = arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (pivot>arr[i]){
                for (int j = i; j >0 ; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
