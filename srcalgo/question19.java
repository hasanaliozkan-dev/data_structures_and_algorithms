import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class question19 {

    static String[] bigSorting(String[] unsorted) {
        String temp;
        for (int i = 0; i <unsorted.length ; i++) {
            boolean isSorted = true;
            for (int j = unsorted.length-1; j >i ; j--) {
                if (unsorted[j].length()<unsorted[j-1].length()){
                    isSorted = false;
                    temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;
                }
                if (unsorted[j].length()==unsorted[j-1].length()){
                    int res = unsorted[j].compareTo(unsorted[j-1]);
                        if (res<0){
                            isSorted = false;
                            temp = unsorted[j-1];
                            unsorted[j-1] = unsorted[j];
                            unsorted[j] = temp;
                        }

                    }
                }
                if (isSorted)
                    break;
            }
        return unsorted;
    }

    public static void main(String[] args) {
        String my = "323";
        String me = "323";
        System.out.println(me.compareTo(my));;
        System.out.println(my.charAt(0));
    }
    /* it doesnt execute within the time limits.!!!!
    * for (int i = 1; i < unsorted.length; i++) {
            for (int j = 0; j < i; j++) {
                if (unsorted[i].length() < unsorted[j].length()) {
                    String temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
                if (unsorted[i].length() == unsorted[j].length()) {
                    int res = unsorted[i].compareTo(unsorted[j]);
                    if(res<0){
                        String temp = unsorted[i];
                        unsorted[i] = unsorted[j];
                        unsorted[j] = temp;
                    }
                }
            }
        }
*/

}






/*    static String[] bigSorting(String[] unsorted) {
        long[] temp = new long[unsorted.length];
        for (int i = 0; i <unsorted.length ; i++) {
            temp[i] = Integer.parseInt(unsorted[i]);
        }
        quickSort(temp,0,temp.length-1);
        for (int i = 0; i <temp.length ; i++) {
            unsorted[i] = String.valueOf(temp[i]);
        }
        return unsorted;
    }
    public static void quickSort(long A[],int p, int r)
    {
        int q;
        if(p<r)
        {
            q=partition(A,p, r);
            quickSort(A,p, q-1);
            quickSort(A,q+1, r);
        }
    }
    public static int partition(long A[],int p, int r){
        long tmp;
        long x = A[r];
        int i = p-1;

        for(int j=p; j<=r-1; j++)
        {
            if(A[j]<=x)
            {
                i++;
                tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
        }
        tmp=A[i+1];
        A[i+1]=A[r];
        A[r]=tmp;
        return i+1;
    }*/


