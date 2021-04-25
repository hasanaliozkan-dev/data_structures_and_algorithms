public class question9 {
    static int[] icecreamParlor(int m, int[] arr) {
        int[] result = new int[2];
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(arr[i] + arr[j] == m){
                    result[0] = j+1;
                    result[1] = i+1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] myarr = {1 ,4 ,5 ,3, 2};
        int m = 4;
        int[] result = icecreamParlor(m,myarr);
        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i]+" ");
        }

    }
}
