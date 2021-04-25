import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;


public class question24 {
    //It didnt pass the testcases because of the time limits.Try it with map structure.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int halfN = n / 2;
        HashSet<Integer> keySet = new HashSet(100);
        ArrayList<String>[] ordered = new ArrayList[100];
        int key;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().replaceAll("\\s+$", "").split(" ");
            key = Integer.valueOf(s[0]);
            if (!keySet.contains(key))
                ordered[key] = new ArrayList<String>();
                ordered[key].add(i < halfN ? "-" : s[1]);
                keySet.add(key);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            if (keySet.contains(i)) {
                sb.append(ordered[i].stream().collect(joining(" ")) + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
    /*static void countSort(List<List<String>> arr) {
        String[][] result= new String[arr.size()][2];
        for (int i = 0; i <arr.size() ; i++) {
            result[i][0] = arr.get(i).get(0);
            result[i][1] = arr.get(i).get(1);
        }
        for (int i=0;i<result.length/2;i++) {
            result[i][1] = "-";
        }
        for (int i = 1; i <result.length ; i++) {
            if(result[i][0].compareTo(result[i-1][0])!=0){

                if (result[i][0].compareTo(result[i-1][0])<0){
                    String[] temp = result[i];
                    result[i] = result[i-1];
                    result[i-1] = temp;
                    i=1;
                }
            }

        }
        for (String[] strings : result) {
            System.out.print(strings[1] + " ");
        }

    }
*/





}
