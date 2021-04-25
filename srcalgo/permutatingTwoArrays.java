import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class permutatingTwoArrays {

    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int[] reverseB = new int[B.length];
        for (int i = B.length-1,j=0; i >=0&& j<B.length; i--,j++) {
            reverseB[j] = B[i];
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(reverseB));
        for (int i = 0; i <A.length ; i++) {
            if (A[i] + reverseB[i]<k) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {

    }
}
