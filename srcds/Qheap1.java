import jdk.dynalink.linker.LinkerServices;

import java.util.*;

public class Qheap1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        Heap heap = new Heap(number);
        while (number>0){
            int ch = scan.nextInt();
            if (ch == 1 ){
                int insert = scan.nextInt();
                heap.insert(insert);
            }
            else if (ch == 2){
                int remove = scan.nextInt();
                heap.remove();
            }
            else if (ch == 3){
                System.out.println(heap.minimum);
            }
            number--;
        }
    }
}
class Heap{
    int[] heap;
    int size,maxSize;
    int minimum = 0;
    public Heap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize+1];
    }
    private int getParentPos(int pos){
        return  pos/2;
    }
    private int getLeftChildPos(int pos){
        return pos*2;
    }
    private int getRightChildPos(int pos){
        return (pos*2)+1;
    }
    private boolean isLeaf(int pos){
        if (pos>=size/2 && pos<=size) return true;

        return false;
    }
    private void swap(int pos1, int pos2) {
        int temp;
        temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[getLeftChildPos(pos)]
                    || heap[pos] > heap[getRightChildPos(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (heap[getLeftChildPos(pos)] < heap[getRightChildPos(pos)]) {
                    swap(pos, getLeftChildPos(pos));
                    minHeapify(getRightChildPos(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, getRightChildPos(pos));
                    minHeapify(getRightChildPos(pos));
                }
            }
        }
    }
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[getParentPos(current)]) {
            swap(current, getParentPos(current));
            current = getParentPos(current);
        }
    }
    public int remove() {
        int popped = heap[minimum];
        heap[minimum] = heap[size--];
        minHeapify(minimum);
        return popped;
    }
    



}
/*easy way of doing this
*   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        Queue<Integer> heap = new PriorityQueue<>();
        while (number>0){
            int ch = scan.nextInt();
            if (ch == 1 ){
                int insert = scan.nextInt();
                heap.add(insert);
            }
            else if (ch == 2){
                int remove = scan.nextInt();
                heap.remove(remove);
            }
            else if (ch == 3){
                System.out.println(heap.peek());
            }
            number--;
        }
    }
    * */