import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static class DirectedGraph {
        /* Adjacency List representation of the given graph */
        private Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

        public String toString() {
            StringBuffer s = new StringBuffer();
            for (Integer v : adjList.keySet())
                s.append("\n    " + v + " -> " + adjList.get(v));
            return s.toString();
        }

        public void add(Integer vertex) {
            if (adjList.containsKey(vertex))
                return;
            adjList.put(vertex, new ArrayList<Integer>());
        }

        public void add(Integer source, Integer dest) {
            add(source);
            add(dest);
            adjList.get(source).add(dest);
        }

        /* Indegree of each vertex as a Map<Vertex, IndegreeValue> */
        public Map<Integer, Integer> inDegree() {
            Map<Integer, Integer> result = new HashMap<Integer, Integer>();
            for (Integer v : adjList.keySet())
                result.put(v, 0);
            for (Integer from : adjList.keySet()) {
                for (Integer to : adjList.get(from)) {
                    result.put(to, result.get(to) + 1);
                }
            }
            return result;
        }

        public Map<Integer, Integer> outDegree() {
            Map<Integer, Integer> result = new HashMap<Integer, Integer>();
            for (Integer v : adjList.keySet())
                result.put(v, adjList.get(v).size());
            return result;
        }

    }

    // Complete the bfsDistance function below.
    public static Map<Integer, Integer> bfsDistance(DirectedGraph digraph, Integer start) {
        Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
        for(Integer i: digraph.adjList.keySet()){
            distance.put(i,-1);
        }
        distance.put(start,0);
        Queue<Integer> digraphQueue = new LinkedList<Integer>();
        digraphQueue.offer(start);
        while (!digraphQueue.isEmpty()){
            Integer temp = digraphQueue.poll();
            int tempDist = distance.get(temp);
            for(Integer neighbour: digraph.adjList.get(temp) ){
                if (distance.get(neighbour) != -1) continue;
                distance.put(neighbour,tempDist+1);
                digraphQueue.offer(neighbour);
            }
        }
            return distance;
    }

    public static boolean isDag(DirectedGraph digraph) {
        Map<Integer,Integer> inDeg= digraph.inDegree();
        Stack<Integer> graphStack = new Stack<>();
        for (Integer i : inDeg.keySet()){
            if (inDeg.get(i) == 0) graphStack.push(i);
        }
        List<Integer> topSort = new ArrayList<>();
        while (!graphStack.isEmpty()){
            Integer temp = graphStack.pop();
            topSort.add(temp);
            for (Integer neighbour : digraph.adjList.keySet()){
                inDeg.put(neighbour,inDeg.get(neighbour)-1);
                if (inDeg.get(neighbour)==0) graphStack.push(neighbour);
            }
        }
        if(topSort.size() != digraph.adjList.size()) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sVertex = Integer.parseInt(bufferedReader.readLine().trim());

        DirectedGraph digraph = new DirectedGraph();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] v = line.split(" ");
            digraph.add(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
        }

        Map<Integer, Integer> bfsd = bfsDistance(digraph, sVertex);
        String s = bfsd.entrySet().stream().map(e -> String.valueOf(e.getValue())).collect(Collectors.joining(" "));
        bufferedWriter.write(s);

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.stream.*;

public class Solution {

    static class ListCell<T> {

        public T datum; // Data for this cell
        public ListCell<T> next; // Next cell

        public ListCell(T datum, ListCell<T> next) {
            this.datum = datum;
            this.next = next;
        }
    }

    static class LinkedList<T> {

        private static final String STRING = " ";

        Solution.ListCell<T> head; // head (first cell) of the List

        public LinkedList() {
            head = null;
        }

        public void insert(T element) {
            head = new ListCell<T>(element, head);
        }

        public void delete(T element) {
            delete(element, head);
        }

        private ListCell<T> delete(T element, ListCell<T> cell) {
            if (cell == null)
                return null;
            if (cell.datum.equals(element))
                return cell.next;
            cell.next = delete(element, cell.next);
            return cell;
        }

        public int size() {
            return size(head);
        }

        private int size(ListCell<T> cell) {
            if (cell == null)
                return 0;
            return size(cell.next) + 1;
        }

        public String toString() {
            return toString(head);
        }

        private String toString(ListCell<T> cell) {
            if (cell == null)
                return "";
            return cell.datum.toString() + STRING + toString(cell.next);
        }
    }

    // Complete the mergeSort function below.
    // !!! Leave the code as is except for the below function, !!!
    // !!! though writing helper function(s) are allowed. !!!
    private static void sort(Solution.LinkedList<Integer> llist){
        mergeSort(llist.head);
    }
    private static ListCell<Integer> mergeSort(ListCell<Integer> head) {
        if(head == null || head.next == null)
            return head;
        ListCell<Integer> slower =head;
        ListCell<Integer> faster = head;
        while (faster.next != null && faster.next.next != null){
            slower = slower.next;
            faster = faster.next.next;
        }

        ListCell<Integer> midCell = slower;
        ListCell<Integer> midNext = midCell.next;
        midCell.next = null;
        ListCell<Integer> leftPart = mergeSort(head);
        ListCell<Integer> rightPart = mergeSort(midNext);

        ListCell<Integer> sorted = merge(rightPart,leftPart);
        return sorted;
    }

    private static ListCell<Integer> merge(ListCell<Integer> leftPart, ListCell<Integer> rightPart) {
        Solution.LinkedList<Integer> result = new Solution.LinkedList<Integer>();
        ListCell<Integer> cell = null;
        if (leftPart == null){
            result.insert(rightPart.datum);
            return rightPart;
        }
        else if (rightPart == null){
            result.insert(leftPart.datum);
            return leftPart;
        }
        else{
            if (leftPart.datum >= rightPart.datum){
                result.insert(leftPart.datum);
                cell = leftPart;
                cell.next = merge(leftPart.next,rightPart);
            }

            else {
                result.insert(rightPart.datum);
                cell = rightPart;
                cell.next = merge(leftPart,rightPart.next);
            }
        }
        return cell;

    }
    */
/* recursive method but it dosesnt work for 3 test cases;


   *//*


    */
/* it doesnt working
    * Solution.LinkedList<Integer> result = new Solution.LinkedList<Integer>();
        while (leftPart != null || rightPart != null){
            if(leftPart!= null && rightPart == null){
                result.insert(leftPart.datum);
                leftPart = leftPart.next;
            }
            else if(leftPart== null && rightPart != null){
                result.insert(rightPart.datum);
                rightPart = rightPart.next;
            }else {
                if(leftPart.datum<rightPart.datum){
                    result.insert(leftPart.datum);
                    leftPart = leftPart.next;
                }else if(leftPart.datum == rightPart.datum){
                    result.insert(leftPart.datum);
                    leftPart = leftPart.next;
                    result.insert(rightPart.datum);
                    rightPart = rightPart.next;
                }else {
                    result.insert(rightPart.datum);
                    rightPart = rightPart.next;
                }

            }
        }*//*


    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int llistCount = Integer.parseInt(br.readLine().trim());

        LinkedList<Integer> llist = new LinkedList<>();

        IntStream.range(0, llistCount).forEach(i -> {
            try {
                Integer llistItem = Integer.parseInt(br.readLine().trim());

                llist.insert(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        sort(llist);
        bufferedWriter.write(llist.toString().trim());

        bufferedWriter.close();

        br.close();
    }

}
*/
