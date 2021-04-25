import java.util.Random;

/*
 * Compare running times of linear search and binary search
 */
public class SearchTest {

   static final int ARRAYSIZE = 10000;
   static final int NTRIALS = 10000;

   public static void main(String[] args) {
      int[] a = new int[ARRAYSIZE];
      for (int i = 0; i < a.length; i++) {
         a[i] = i;
      }

      // test average search time for linear and binary search
      // over a large number of trials
      Random rand = new Random();
      int linearSearchTime = 0;
      int binarySearchTime = 0;
      for (int i = 0; i < NTRIALS; i++) {
         int r = rand.nextInt(ARRAYSIZE);
         linearSearchTime += linearSearch(a, r);
         binarySearchTime += binarySearch(a, r);
      }
      int linearAvg = linearSearchTime / NTRIALS;
      int binaryAvg = binarySearchTime / NTRIALS;
      System.out.println("linear search avg: " + linearAvg);
      System.out.println("binary search avg: " + binaryAvg);
   }

   // returns number of basic steps
   static int linearSearch(int[] a, int item) {
      int steps = 0;
      for (int x : a) {
         steps++;
         if (x == item) break;
      }
      return steps; // not found
   }

   // elements of a must be ordered
   // returns number of basic steps
   static int binarySearch(int[] a, int item) {
      int steps = 0;
      int low = 0;
      int high = a.length - 1;
      while (low <= high) {
         steps++;
         int mid = (low + high) / 2;
         if (a[mid] < item) low = mid + 1;
         else if (a[mid] > item) high = mid - 1;
         else return steps;
      }
      return steps; // not found
   }

}