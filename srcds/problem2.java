public class problem2 {

        //easy
    static int hourglassSum(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        int maxSum = -63;//en az olabilicek değeri koydum.
        for (int i = 0; i <rows-2; i++) {
            for (int j = 0; j <columns-2 ; j++) {
                int sum = arr[i][j] + arr[i][j+1] +arr[i][j+2] + arr[i+1][j+1] +arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(sum > maxSum)
                    maxSum = sum;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
