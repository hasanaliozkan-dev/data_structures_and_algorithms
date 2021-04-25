
import java.util.LinkedList;
import java.util.Scanner;
public class maximum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        MyStack stack = new MyStack();
        while (number>0){
            int ch = scan.nextInt();
            if (ch == 1){
                int value = scan.nextInt();
                stack.push(value);
            }
            else if(ch == 2){
                stack.pop();
            }
            else if (ch == 3){
                stack.printMax();
            }
            number--;
        }


    }
}
class MyStack {
    private int max = Integer.MIN_VALUE;
    private LinkedList<Integer> stack = new LinkedList<>();

    public void push(int data){
        stack.add(data);
        if (data>this.max)
            this.max = data;
    }
    public int pop(){
        int ret = Integer.MIN_VALUE;
        if (!stack.isEmpty()){
            ret = stack.removeLast();
            if(ret == max){
                max = Integer.MIN_VALUE;
                for (int i = 0; i <stack.size() ; i++) {
                    if (stack.get(i) > max)
                        max = stack.get(i);
                }
            }
        }
        return ret;
    }

    public void printMax(){
        System.out.println(this.max);
    }
}