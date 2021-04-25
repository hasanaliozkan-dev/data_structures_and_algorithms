import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question10 {

    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            listA.add(arr[i]);

        }
        for (int i = 0; i < brr.length; i++) {
            listB.add(brr[i]);
        }
        for (int i = 0; i <listA.size() ; i++) {
            if (listB.contains(listA.get(i))){
                listB.remove(listA.get(i));
            }

        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <listB.size() ; i++) {
            if(!(resultList.contains(listB.get(i)))){
                resultList.add(listB.get(i));
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i <resultList.size() ; i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }


    public static void main(String[] args) {
        int [] myarray = {12,23,3,5,5,4};
        //The one line code of writing a whole array without loop.
        System.out.println(Arrays.toString(myarray).replace("[","")
                .replace("]","").replace(",",""));
    }
    /*    static int[] unique(int[] a){
        int[] result = new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i <result.length ; i++) {

        }

        return result;
    }
    static int[] missingNumbers(int[] arr, int[] brr) {
        Arrays.sort(arr);
        Arrays.sort(brr);
        List<Integer> difference = new ArrayList<>();

        for (int i = 0,j=0,k=0; i <arr.length && j<brr.length; i++,j++) {
            if(arr[i] != brr[j]){
                difference.add(brr[j]);
                i--;
                k++;
            }
        }
        List<Integer> uniqueDiff = new ArrayList<>();

        for (int i = 0; i <difference.size(); i++) {
            if (!(uniqueDiff.contains(difference.get(i)))){
                uniqueDiff.add(difference.get(i));
            }
        }
        int[] result = new int[uniqueDiff.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i] = uniqueDiff.get(i);
        }
        return result;
    }*/
       /* Arrays.sort(arr);
        Arrays.sort(brr);
        List<Integer> difference = new ArrayList<>();

        for (int i = 0,j=0,k=0; i <arr.length && j<brr.length; i++,j++) {
            if(arr[i] != brr[j]){
                difference.add(brr[j]);
                i--;
                k++;
            }
        }
        List<Integer> uniqueDiff = new ArrayList<>();

        for (int i = 0; i <difference.size(); i++) {
            if (!(uniqueDiff.contains(difference.get(i)))){
                uniqueDiff.add(difference.get(i));
            }
        }
        int[] result = new int[uniqueDiff.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i] = uniqueDiff.get(i);
        }
        return result;*/
}
