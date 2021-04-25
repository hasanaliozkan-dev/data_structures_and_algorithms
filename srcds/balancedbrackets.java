import java.util.Stack;

public class balancedbrackets {

    static String isBalanced(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) =='{'){
                brackets.push(s.charAt(i));
                continue;
            }
            if(brackets.isEmpty())
                return "NO";
            if (s.charAt(i) ==')' && brackets.peek() == '(')
                brackets.pop();
            else if (s.charAt(i) ==']' && brackets.peek() == '[')
                brackets.pop();
            else if (s.charAt(i) =='}' && brackets.peek() == '{')
                brackets.pop();
            else
                return"NO";
        }
        if (brackets.isEmpty())
            return "YES";
        return "NO";
    }


    public static void main(String[] args) {
        System.out.println(isBalanced("{(([])[])[]]}"));
    }
}
