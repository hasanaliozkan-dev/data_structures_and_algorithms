import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem3 {
        //easy

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        for(int i = 0;i<d;i++){
            int temp = arr.remove(0);
            arr.add(temp);

        }
        return arr;
    }
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(3);
        System.out.println(result.size());
        int temp = result.remove(0);
        System.out.println(temp);
        System.out.println(result.size());
        for (Integer integer : result)
            System.out.println(integer);
        int[] mylist = {1,2,3,4,5,6,7,8,9};
        System.out.println("");
        for (int item:mylist)
            System.out.println(item);


    }

    }

