package sort;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

   static Random rand = new Random();

   public void sort(T[] x) {
      sort(x, 0, x.length);
   }

   // sort the portion of Comparable array x between
   // lo (inclusive) and hi (exclusive) in place
   // does not touch other parts of x
   private void sort(T[] x, int lo, int hi) {

      // base case
      if (hi <= lo + 1) return;

      // pick random pivot
      T pivot = x[lo + rand.nextInt(hi - lo)];

      // partition the elements about the pivot
      int i = lo;
      int j = hi - 1;
      while (true) {
         // advance indices
         while (i < j && x[i].compareTo(pivot) < 0)
            i++;
         while (i < j && x[j].compareTo(pivot) > 0)
            j--;
         // done?
         if (i == j) break;
         // swap
         T tmp = x[i];
         x[i] = x[j];
         x[j] = tmp;
      }

      // recursively sort the partition elements
      sort(x, lo, j);
      sort(x, j, hi);
   }
}
