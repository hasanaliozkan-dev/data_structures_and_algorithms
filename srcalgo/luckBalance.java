import javax.swing.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class luckBalance {
    /*static int luckBalance(int k, int[][] contests) {
        Map<Integer,Integer> hashMap =  new HashMap<>();
        int important = 0;
        int total= 0;
        for (int i = 0; i<contests.length;i++){
            total += contests[i][0];
            hashMap.put(i,contests[i][0]);
            if(contests[i][1] == 1) important++;
        }
        int diff = important -k;

        while(diff>0){
            int min = 0;
            for (int i = 0; i <hashMap.size() ; i++) {
                if (hashMap.get(i)<hashMap.get(min)) min = i;
            }
            total = total - hashMap.get(min)- hashMap.get(min);
            diff--;
            hashMap.replace(min,hashMap.get(min),999999);
        }


        return total;
    }*/
    /*static int luckBalance(int k, int[][] contests) {
        int important = 0;
        int total= 0;
        for (int i = 0; i<contests.length;i++){
            total += contests[i][0];
            if(contests[i][1] == 1) important++;
        }
        int diff = important -k;

        while(diff>0){
            int min = 0;
            for (int i = 0;i<contests.length;i++){
                if(contests[i][0]<contests[min][0]) min =i;
            }
            total= total-contests[min][0]*2;
            diff--;
            contests[min][0] =Integer.MAX_VALUE;

        }


        return total;
    }*/
    static int luckBalance(int k, int[][] contests) {
        List<Integer> impoCont = new ArrayList<>();
        int important = 0;
        int total= 0;
        for (int i = 0; i <contests.length ; i++) {
            total+= contests[i][0];
            if (contests[i][1] == 1){
                impoCont.add(contests[i][0]);
                important++;
            }
        }
        Collections.sort(impoCont);
        int diff = important-k;
        int lost = 0;
        while (diff>0){
            lost += impoCont.get(0);
            impoCont.remove(0);
            diff--;
        }
        return total-lost*2;

    }

    public static void main(String[] args) {
        int[][] contests = {{5,1},{2,1},{1,1},{8,1},{10,0},{5,0}};
        int[][] contests2 = {{13,1},{10,1},{9,1},{8,1},{13,1},{12,1},{18,1},{13,1}};
        System.out.println(luckBalance(3,contests));
        System.out.println(Integer.MAX_VALUE);

    }
}
