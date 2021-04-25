public class question6 {
    static void miniMaxSum(int[] arr) {
        long sum = 0,min =1000000000,max=0;
        for (int i = 0; i <arr.length ; i++) {
            if(min>arr[i])
                min = arr[i];
            if (max<arr[i])
                max=arr[i];
            sum+=arr[i];
        }
        System.out.println((sum-max)+" "+(sum-min));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        miniMaxSum(arr);
    }
}
