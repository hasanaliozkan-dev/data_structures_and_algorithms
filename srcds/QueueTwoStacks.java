import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        while (number>0){
            int ch = scan.nextInt();
            if(ch == 1 ){
                int value = scan.nextInt();
                stack1.push(value);
            }
            else if (ch == 2 ){
                if (stack2.isEmpty()){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else if (ch == 3){
                if (stack2.isEmpty()){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                System.out.println(stack2.peek());
            }
            number--;


        }
    }
}

