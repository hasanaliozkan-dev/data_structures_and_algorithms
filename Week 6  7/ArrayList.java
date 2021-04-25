/**
 * An array implementation of List.
 * 
 */
public class ArrayList<T> implements List<T> {

   private Object[] theArray; // holds the List elements
   private int size; // index of next empty array slot

   /**
    * Constructor.
    * 
    * @param capacity
    *           the max size of the List
    */
   public ArrayList(int capacity) {
      theArray = new Object[capacity];
      size = 0;
   }

   public ArrayList() {
      this(12);
   }

   /**
    * Insert an element onto the list.
    * 
    * @param element
    *           the element to insert
    */
   public void insert(T element) {
      // if beyond end, allocate a new array, copy over old one
      if (size == theArray.length) {
         Object[] newArray = new Object[theArray.length * 2 + 1];
         System.arraycopy(theArray, 0, newArray, 0, size);
         theArray = newArray;
      }
      theArray[size++] = element;
   }

   private boolean equal(T x, Object y) {
      return x != null ? x.equals(y) : y == null;
   }

   /**
    * Delete an element from the list.
    * 
    * @param element
    *           the element to delete
    */
   public void delete(T element) {
      for (int i = 0; i < size; i++) {
         if (equal(element, theArray[i])) {
            for (int j = i + 1; j < size; j++)
               theArray[j - 1] = theArray[j];
            size--;
            break;
         }
      }
   }

   /**
    * Report true if list contains element.
    * 
    * @param element
    *           the element to check for
    * @return true iff element is in the List
    */
   public boolean contains(T element) {
      for (int i = 0; i < size; i++)
         if (equal(element, theArray[i])) return true;
      return false;
   }

   /**
    * Report number of elements in List.
    * 
    * @return number of elements
    */
   public int size() {
      return size;
   }

   /**
    * String representation.
    * 
    * @return the String representation
    */
   public String toString() {
      String string = "[";
      for (int i = 0; i < size; i++)
         string += " " + theArray[i].toString();
      string += " ]";
      return string;
   }
}
