import java.util.ArrayList;
import java.util.NoSuchElementException;

class PriorityQueue<E extends Comparable<E>> extends ArrayList<E> {
   
   public void put(E obj) {
      add(obj);
      rotateUp(size() - 1);
   }
   
   public E get() {
      if (isEmpty()) throw new NoSuchElementException();
      E temp = get(0);
      set(0, get(size() - 1));
      remove(size() - 1);
      rotateDown(0);
      return temp;
   }
   
   private void rotateUp(int index) {
      if (index == 0) return;
      int parent = (index - 1)/2;
      if (get(parent).compareTo(get(index)) <= 0) return;
      swap(index, parent);
      rotateUp(parent);
   }
   
   private void rotateDown(int index) {
      int child = 2*(index + 1); //right child
      if (child >= size() || get(child - 1).compareTo(get(child)) < 0) child -= 1;
      if (child >= size()) return;
      if (get(index).compareTo(get(child)) <= 0) return;
      swap(index, child);
      rotateDown(child);
   }
   
   private void swap(int index1, int index2) {
      E temp = get(index1);
      set(index1, get(index2));
      set(index2, temp);
   }      
}

class HeapSort {
   public static void main(String[] args) {
      Integer[] a = new Integer[20];
      java.util.Random random = new java.util.Random();
      for (int i = 0; i < a.length; i++) {
         a[i] = new Integer(random.nextInt(100));
         System.out.print(a[i] + " ");
      }
      System.out.println();
      heapSort(a);
      for (Integer x : a) {
         System.out.print(x + " ");
      }
      System.out.println();
   }
   
   public static <E extends Comparable<E>> void heapSort(E[] a) {
      PriorityQueue<E> pq = new PriorityQueue<E>();
      for (E x : a) pq.put(x);
      for (int i = 0; i < a.length; i++) a[i] = pq.get();
   }
}
