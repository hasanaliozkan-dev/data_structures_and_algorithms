import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class equlastacks {
    public static int equalStacks( List<Integer> h1,  List<Integer> h2,  List<Integer> h3) {
        Stack<Integer> stackh1 = new Stack<>();
        Stack<Integer> stackh2 = new Stack<>();
        Stack<Integer> stackh3 = new Stack<>();
        int height1=0,height2=0,height3=0;
        for (int i = h1.size()-1;i>=0 ;i--) {
            height1 += h1.get(i);
            stackh1.push(height1);
        }
        for (int i = h2.size()-1;i>=0 ;i--) {
            height2 += h2.get(i);
            stackh2.push(height2);
        }
        for (int i = h3.size()-1;i>=0 ;i--) {
            height3 += h3.get(i);
            stackh3.push(height3);
        }


        while (true){
            if (stackh1.isEmpty() || stackh2.isEmpty() || stackh3.isEmpty())
                return 0;
            height1 = stackh1.peek();
            height2 = stackh2.peek();
            height3 = stackh3.peek();

            if (height1 == height2 && height2 == height3)
                return height1;


            if (height1>=height2 && height1>=height3)
                stackh1.pop();
            else if (height2>=height1 && height2>=height3)
                stackh2.pop();
            else stackh3.pop();
        }

    }
    public static void main(String[] args) {
        LinkedList<Integer> deneme = new LinkedList<>();
        deneme.add(3);
        deneme.add(4);
        deneme.add(5);
        System.out.println(deneme.removeLast());
        System.out.println();
        for (int item:deneme ) {
            System.out.println(item);
        }
    }
}
