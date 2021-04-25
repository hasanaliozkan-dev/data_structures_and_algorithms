/**
 * A linked list implementation of List using lots of recursion.
 * 
 */
public class LinkedListRecursive<T> implements List<T> {

   ListCell<T> head; // head (first cell) of the List

   /**
    * Constructor.
    */
   public LinkedListRecursive() {
      head = null;
   }

   /**
    * Insert an element onto the list.
    * 
    * @param element
    *           the element to insert
    */
   public void insert(T element) {
      head = new ListCell<T>(element, head);
   }

   /**
    * Delete an element from the list.
    * 
    * @param element
    *           the element to delete
    */
   public void delete(T element) {
      delete(element, head);
   }

   private ListCell<T> delete(T element, ListCell<T> cell) {
      if (cell == null) return null;
      if (cell.datum.equals(element)) return cell.next;
      cell.next = delete(element, cell.next);
      return cell;
   }

   /**
    * Report true if list contains element.
    * 
    * @param element
    *           the element to check for
    * @return true iff element is in the List
    */
   public boolean contains(T element) {
      return contains(element, head);
   }

   private boolean contains(T element, ListCell<T> cell) {
      if (cell == null) return false;
      return cell.datum.equals(element) || contains(element, cell.next);
   }

   /**
    * Report number of elements in List.
    * 
    * @return number of elements
    */
   public int size() {
      return size(head);
   }

   private int size(ListCell<T> cell) {
      if (cell == null) return 0;
      return size(cell.next) + 1;
   }

   /**
    * String representation.
    * 
    * @return the String representation
    */
   public String toString() {
      return "[" + toString(head) + " ]";
   }

   private String toString(ListCell<T> cell) {
      if (cell == null) return "";
      return " " + cell.datum.toString() + toString(cell.next);
   }
}
