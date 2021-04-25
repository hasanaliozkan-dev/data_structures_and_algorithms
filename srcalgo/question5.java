public class question5 {

    static void staircase(int n) {

        for (int i = 1; i <=n ; i++) {
            int space = n;
            while (space-- > i){
                System.out.print(" ");
            }
            while (space-- >= 0){
                System.out.print('#');
            }
            System.out.println();

        }

       for (int i = 1; i <=n ; i++) {
            System.out.print("#".repeat(i).indent(n-i));
        }
    }
    public static void main(String[] args) {
        staircase(6);
        for (int i = 1; i <=6 ; i++) {
            System.out.print("#".repeat(i).indent(6-i));
        }
        String  repetaded  = "*".repeat(3);
        System.out.println(repetaded);
    }
}
