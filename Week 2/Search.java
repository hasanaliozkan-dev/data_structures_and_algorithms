public class Search {

   static boolean linearSearch(int[] a, int item) {
      for (int x : a) {
         if (x == item) return true;
      }
      return false;
   }

   static boolean binarySearch(int[] a, int item) {
      int low = 0;
      int high = a.length - 1;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (a[mid] < item) low = mid + 1;
         else if (a[mid] > item) high = mid - 1;
         else return true;
      }
      return false;
   }
}
