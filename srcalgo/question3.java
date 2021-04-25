import java.util.List;

public class question3 {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int total1 = 0,total2 = 0,x = 0,y= arr.size()-1;
        for (int i = 0; i <arr.size() ; i++) {
            total1 += arr.get(i).get(i);
            total2 += arr.get(x).get(y);
            x++;
            y--;
        }


        return Math.abs(total1-total2);
    }

    public static void main(String[] args) {

    }

}
