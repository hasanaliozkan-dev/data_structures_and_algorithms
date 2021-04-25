import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class problem4 {
    //easy
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries){
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> lol = new ArrayList<>();
        int lastAnswer = 0;
        for (int i = 0; i <n ; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            lol.add(arr);
        }
        for (int i = 0; i <queries.size(); i++) {
           List<Integer> query = queries.get(i);
           if(query.get(0) == 1){
                lol.get((query.get(1)^lastAnswer)%n).add(query.get(2));
           }else{
                List<Integer> seqList = lol.get((query.get(1)^lastAnswer)%n);
                lastAnswer = seqList.get(query.get(2) % seqList.size());
                result.add(lastAnswer);
           }
        }
        return result;
    }


    public static void main(String[] args) {
        int bitWiseOp = 0^1;
        int bitWiseOp1 = 0^0;
        int bitWiseOp2 = 1^1;
        System.out.println(bitWiseOp2);

    }
}
