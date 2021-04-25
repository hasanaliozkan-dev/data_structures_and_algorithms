import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class problem7 {

    static int twoStacks(int x, int[] a, int[] b) {
        int indexA =0,indexB=0,count=0,sum=0;
        while (indexA<a.length && sum + a[indexA]<=x){
            sum += a[indexA];
            indexA++;
        }
        count = indexA;
        indexA--;
        while (indexB<b.length&&indexA<a.length){
            sum += b[indexB];
            if (sum > x) {
                while (indexA>=0){
                    sum-=a[indexA];
                    indexA--;
                    if (sum<=x){
                        break;
                    }
                }
            }
            if (sum>x &&indexA<0){
                indexB--;
                break;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Object obj = true;
        if (obj instanceof Integer){
            System.out.println("Yes");
        }else
            System.out.println("No");

    }
}
