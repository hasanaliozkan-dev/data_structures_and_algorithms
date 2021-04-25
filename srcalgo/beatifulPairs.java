import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class beatifulPairs {
    static int beautifulPairs(int[] A, int[] B) {
        Map<Integer,Integer> pairs = new HashMap<>();
        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j <B.length; j++) {
                if (A[i] == B[j]){
                    pairs.put(i,j);
                    A[i] = -1;
                    B[j] = -1;
                }
            }
        }
        if (pairs.size() ==A.length) return pairs.size()-1;
        return pairs.size()+1;
    }



    public static void main(String[] args) {

    }
}
