/**
 * A simple interface for a list of elements.
 */
public interface List<T> {

   /**
    * Insert an element onto the list.
    * 
    * @param element
    *           the element to insert
    */
   public void insert(T element);

   /**
    * Delete an element from the list.
    * 
    * @param element
    *           the element to delete
    */
   public void delete(T element);

   /**
    * Report true if list contains element.
    * 
    * @param element
    *           the element to check for
    * @return true iff element is in the List
    */
   public boolean contains(T element);

   /**
    * Report number of elements in List.
    * 
    * @return number of elements
    */
   public int size();
}

/**
 * List cell (a helper class; visible to other classes in same package).
 */
class ListCell<T> {

   public T datum; // Data for this cell
   public ListCell<T> next; // Next cell

   /**
    * Constructor.
    */
   public ListCell(T datum, ListCell<T> next) {
      this.datum = datum;
      this.next = next;
   }
}
