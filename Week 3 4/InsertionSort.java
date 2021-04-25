package sort;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

   public void sort(T[] x) {

      // scan through all elements
      for (int i = 1; i < x.length; i++) {
         // invariant is: x[0],...,x[i-1] are sorted
         // now find rightful position for x[i]
         T tmp = x[i];
         int j;
         // move x[i] into sorted portion
         for (j = i; j > 0 && x[j - 1].compareTo(tmp) > 0; j--)
            x[j] = x[j - 1];
         x[j] = tmp;
      }
   }
}
