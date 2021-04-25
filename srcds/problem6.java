import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class problem6 {
    //hard
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] list = new int[n+1];
        for (int[] query : queries) {
            if (query[1] - query[0] != 1) {
                for (int j = query[0]; j <= query[1]; j++) {
                    list[j] = list[j] + query[2];
                }
            } else {
                list[query[0]] = list[query[0]] + query[2];
            }
        }
        long max = 0;
        for (int item:list) {
            if(item>max){
                max = item;
            }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


