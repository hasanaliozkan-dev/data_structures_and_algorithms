import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.PriorityQueue;

public class Cookie {
    static int cookies(int k, int[] A) {
        Queue<Integer> pqueue = new PriorityQueue<Integer>();
        for (int i = 0; i <A.length ; i++) {
            pqueue.add(A[i]);
        }
        int operations = 0;
        while(pqueue.size()>1){
            if (pqueue.peek()>=k)
                return operations;
            else {
                int cookie = pqueue.remove() + pqueue.remove()*2;
                pqueue.add(cookie);
                operations++;
            }
        }
        if (pqueue.size() > 0 && pqueue.peek() >= k)
            return operations;

        return -1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine().split(" ");
        bufferedReader.readLine().trim();
        int[] cookie = {1,2,3,9,10,12};
        System.out.println(cookies(90,cookie));
    }
}
/* it wants if the situation impossible return -1!!!1
*  static int cookies(int k, int[] A) {
        LinkedList<Integer> llist = new LinkedList<Integer>();
        for (int i = 0; i <A.length ; i++) {
            llist.add(A[i]);
        }
        boolean flag = true;
        int operations = 0;
        while (flag) {

            for (int i = 0; i < llist.size() && flag; i++) {
                if (llist.get(i) < k){
                    operations++;
                    break;
                }
                flag = false;
            }
            int sweatness = llist.get(0) + llist.get(1)*2;
            llist.removeFirst();
            llist.removeFirst();
            llist.add(0,sweatness);

        }


        return operations;
    }*/
