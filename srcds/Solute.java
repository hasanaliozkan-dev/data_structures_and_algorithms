import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solute {

    static class TreeCell<T> {

        public T datum;
        public TreeCell<T> left, right;

        public TreeCell(T datum) {
            this.datum = datum;
            this.left = null;
            this.right = null;
        }

    }

    private static ArrayList<Integer> getPostOrder(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        /*
        * Intuition:
        in Inorder, root splits left and right children:
        looping preOrder
        1,if the next is on the left, it is the left child;
        2, if right, the stack "bottom" will its parent; then put right to the bottom.
        Any node before right has already built.

*/
        // creating tree
        Map<Integer,Integer> treeMap = new HashMap<>();
        for (int i = 0; i <inOrder.size() ; i++) {
            treeMap.put(inOrder.get(i),i);
        }
        Stack<TreeCell<Integer>> treeStack = new Stack<>();
        TreeCell<Integer> root = new TreeCell<>(preOrder.get(0));
        treeStack.push(root);
        for (int i = 1; i <preOrder.size() ; i++) {
            int  datum = preOrder.get(i);
            TreeCell<Integer> cell = new TreeCell<>(datum);
            if (treeMap.get(datum)<treeMap.get(treeStack.peek().datum)){
                treeStack.peek().left = cell;
            }
            else{
                TreeCell<Integer> parent = null;
                while (!treeStack.isEmpty() && treeMap.get(datum) > treeMap.get(treeStack.peek().datum)) {
                    parent = treeStack.pop();
                }
                parent.right = cell;
            }
            treeStack.push(cell);
        }
        // finding postOrder
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        Stack<TreeCell<Integer>> stack1 = new Stack<TreeCell<Integer>>();
        Stack<TreeCell<Integer>> stack2 = new Stack<TreeCell<Integer>>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeCell<Integer> treeCell = stack1.pop();
            stack2.push(treeCell);
            if (treeCell.left!=null){
                stack1.push(treeCell.left);
            }
            if (treeCell.right!=null){
                stack1.push(treeCell.right);
            }
        }
        while (!stack2.empty()){
            TreeCell<Integer> tempCell = stack2.pop();
            postOrder.add(tempCell.datum);
        }
        return postOrder;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> preOrder, inOrder, postOrder;

        preOrder = new ArrayList<>();
        for (String s : br.readLine().trim().split(" ")) {
            preOrder.add(Integer.parseInt(s));
        }

        inOrder = new ArrayList<>();
        for (String s : br.readLine().trim().split(" ")) {
            inOrder.add(Integer.parseInt(s));
        }

        postOrder = getPostOrder(preOrder, inOrder);

        System.out.println(postOrder.stream().map(v -> Integer.toString(v)).collect(Collectors.joining(" ")));

        br.close();

    }
    /*
    private static ArrayList<Integer> getPostOrder(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        Set<TreeCell<Integer>> treeSet = new HashSet<TreeCell<Integer>>();
        Stack<TreeCell<Integer>> treeStack = new Stack<TreeCell<Integer>>();
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        TreeCell<Integer> root = null;
        for (int i = 0,j = 0; i < preOrder.size();) {
            TreeCell<Integer> temp = null;
            do {
                temp = new TreeCell<Integer>(preOrder.get(i));
                if(root == null)
                    root = temp;
                if (!(treeStack.isEmpty())){
                    TreeCell<Integer> item = treeStack.peek();
                    if (treeSet.contains(item)){
                        treeSet.remove(item);
                        treeStack.pop().right = temp;
                    }
                    else {
                        treeStack.peek().left = temp;
                    }
                }
                treeStack.push(temp);
            }
            while (preOrder.get(i++) != inOrder.get(j) && i<preOrder.size());
            temp = null;
            while (!treeStack.isEmpty()&& j<inOrder.size()&&treeStack.peek().datum == inOrder.get(j)){
                temp = treeStack.pop();
                j++;
            }
            if(temp != null){
                treeSet.add(temp);
                treeStack.push(temp);
            }
        }
        Stack<TreeCell<Integer>> stack1 = new Stack<TreeCell<Integer>>();
        Stack<TreeCell<Integer>> stack2 = new Stack<TreeCell<Integer>>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeCell<Integer> treeCell = stack1.pop();
            stack2.push(treeCell);
            if (treeCell.left!=null){
                stack1.push(treeCell.left);
            }
            if (treeCell.right!=null){
                stack1.push(treeCell.right);
            }
        }
        while (!stack2.empty()){
            TreeCell<Integer> tempCell = stack2.pop();
            postOrder.add(tempCell.datum);
        }
        return postOrder;
    }

    * */

}
