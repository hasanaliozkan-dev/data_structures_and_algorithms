package sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sorter<T> {

   public void sort(T[] x) {
      sort(x, 0, x.length, Arrays.copyOf(x, x.length));
   }

   // sort the portion of Comparable array x between lo
   // (inclusive) and hi (exclusive), using y as temp
   // does not touch other parts of y or x
   private void sort(T[] x, int lo, int hi, T[] y) {

      // base case
      if (hi <= lo + 1) return; // nothing to do

      // at least 2 elements -- split and recursively sort
      int mid = (lo + hi) / 2;
      sort(x, lo, mid, y);
      sort(x, mid, hi, y);
      merge(x, lo, mid, hi, y); // merge sorted sublists
   }

   // merge 2 subarrays of x, using y as temp
   // subarrays are between lo and mid and between
   // mid and hi, respectively
   private void merge(T[] x, int lo, int mid, int hi, T[] y) {
      int i = lo; // subarray pointers
      int j = mid;
      int k = lo; // destination pointer

      while (i < mid && j < hi) {
         y[k++] = (x[i].compareTo(x[j]) > 0) ? x[j++] : x[i++];
      }

      // one of the subarrays is empty
      // copy remaining elements from the other
      System.arraycopy(x, i, y, k, mid - i);
      System.arraycopy(x, j, y, k, hi - j);
      // now copy everything back to original array
      System.arraycopy(y, lo, x, lo, hi - lo);
   }
}
