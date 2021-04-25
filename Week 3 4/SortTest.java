package sort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

   Integer[][] sorted = new Integer[6][];
   Integer[][] random = new Integer[6][];
   Integer[][] backwards = new Integer[6][];
   Integer[][] testSorted = new Integer[6][];
   Integer[][] testRandom = new Integer[6][];
   Integer[][] testBackwards = new Integer[6][];

   Random rand = new Random();

   @Before
   public void setUp() throws Exception {
      sorted[0] = new Integer[0];
      sorted[1] = new Integer[1];
      sorted[2] = new Integer[2];
      sorted[3] = new Integer[3];
      sorted[4] = new Integer[10];
      sorted[5] = new Integer[1000];

      // initialize arrays
      for (int i = 0; i < sorted.length; i++) {
         random[i] = Arrays.copyOf(sorted[i], sorted[i].length);
         backwards[i] = Arrays.copyOf(sorted[i], sorted[i].length);
         for (int j = 0; j < sorted[i].length; j++) {
            sorted[i][j] = j;
            backwards[i][j] = sorted[i].length - j - 1;
            int k = rand.nextInt(j + 1); // place for j in random[i]
            if (k < j) {
               random[i][j] = random[i][k];
               random[i][k] = j;
            } else random[i][j] = j;
         }
         testSorted[i] = Arrays.copyOf(sorted[i], sorted[i].length);
         testRandom[i] = Arrays.copyOf(random[i], random[i].length);
         testBackwards[i] = Arrays.copyOf(backwards[i], backwards[i].length);
      }
   }

   private void copy(Integer[][] source, Integer[][] dest) {
      for (int i = 0; i < source.length; i++) {
         System.arraycopy(source[i], 0, dest[i], 0, source[i].length);
      }
   }

   private void copyAll() {
      copy(sorted, testSorted);
      copy(random, testRandom);
      copy(backwards, testBackwards);
   }

   private void sort(Sorter<Integer> s) {
      for (Integer[] arr : testSorted) s.sort(arr);
      for (Integer[] arr : testRandom) s.sort(arr);
      for (Integer[] arr : testBackwards) s.sort(arr);
   }

   private boolean sorted(Integer[][] arrays) {
      for (int i = 0; i < arrays.length; i++) {
         for (int j = 0; j < arrays[i].length; j++) {
            if (!arrays[i][j].equals(sorted[i][j])) return false;
         }
      }
      return true;
   }

   @Test
   public void insertionSortTest() {
      copyAll();
      sort(new InsertionSort<Integer>());
      assertTrue(sorted(testRandom));
      assertTrue(sorted(testSorted));
      assertTrue(sorted(testBackwards));
   }

   @Test
   public void selectionSortTest() {
      copyAll();
      sort(new SelectionSort<Integer>());
      assertTrue(sorted(testRandom));
      assertTrue(sorted(testSorted));
      assertTrue(sorted(testBackwards));
   }

   @Test
   public void mergeSortTest() {
      copyAll();
      sort(new MergeSort<Integer>());
      assertTrue(sorted(testRandom));
      assertTrue(sorted(testSorted));
      assertTrue(sorted(testBackwards));
   }

   @Test
   public void quickSortTest() {
      copyAll();
      sort(new QuickSort<Integer>());
      assertTrue(sorted(testRandom));
      assertTrue(sorted(testSorted));
      assertTrue(sorted(testBackwards));
   }
}
