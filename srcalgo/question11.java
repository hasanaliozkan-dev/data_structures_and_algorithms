import java.util.List;

public class question11 {
    //easy
    static String balancedSums(List<Integer> arr) {

        int leftSum=0,rightSum =0;
        for (int i = 0; i <arr.size() ; i++) {
            rightSum += arr.get(i);
        }
        for (int i = 0; i <arr.size() ; i++) {
            rightSum -= arr.get(i);
            if(rightSum == leftSum)
                return  "YES";
            leftSum += arr.get(i);
        }
        return "NO";

    }
}
