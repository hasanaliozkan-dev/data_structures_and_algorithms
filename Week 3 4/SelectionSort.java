package sort;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {

   public void sort(T[] x) {

      for (int i = 0; i < x.length - 1; i++) {
         // find min in x[i],...,x[n-1]
         int min = i;
         for (int j = i + 1; j < x.length; j++) {
            if (x[j].compareTo(x[min]) < 0) min = j;
         }
         // swap
         T tmp = x[i];
         x[i] = x[min];
         x[min] = tmp;
      }
   }
}
