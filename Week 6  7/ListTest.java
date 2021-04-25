public class ListTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
      ArrayList<Integer> al = new ArrayList<Integer>();
      for (int i = 0; i < 20; i++) {
         al.insert(i + 100);
      }
      al.delete(107);
      al.insert(42);
      System.out.println(al);

      LinkedListIterative<Integer> lli = new LinkedListIterative<Integer>();
      for (int i = 0; i < 20; i++) {
         lli.insert(i + 100);
      }
      lli.delete(107);
      lli.insert(42);
      System.out.println(lli);

      LinkedListRecursive<Integer> llr = new LinkedListRecursive<Integer>();
      for (int i = 0; i < 20; i++) {
         llr.insert(i + 100);
      }
      llr.delete(107);
      llr.insert(42);
      System.out.println(llr);

      lli.head = iterativeReverse(lli.head);
      llr.head = iterativeReverse(llr.head);
      System.out.println(lli);
      System.out.println(llr);
      lli.head = recursiveReverse(lli.head);
      llr.head = recursiveReverse(llr.head);
      System.out.println(lli);
      System.out.println(llr);
   }

   public static <T> ListCell<T> iterativeReverse(ListCell<T> c) {
      ListCell<T> rev = null;
      for (; c != null; c = c.next) {
         rev = new ListCell<T>(c.datum, rev);
      }
      return rev;
   }

   public static <T> ListCell<T> recursiveReverse(ListCell<T> c) {
      return recursiveReverse(c, null);
   }

   private static <T> ListCell<T> recursiveReverse(ListCell<T> c, ListCell<T> r) {
      if (c == null) return r;
      return recursiveReverse(c.next, new ListCell<T>(c.datum, r));
   }

}
