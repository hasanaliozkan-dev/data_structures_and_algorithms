
/**
 * A binary search tree on Strings.
 */
public class BST {

   TreeCell<String> root; // The root of the BST

   public BST() {
      root = null;
   }

   /**
    * Insert. Nothing happens if the string is already in the BST.
    */
   public void insert(String string) {
      root = insert(string, root);
   }

   private static TreeCell<String> insert(String string, TreeCell<String> node) {
      if (node == null) return new TreeCell<String>(string);
      int compare = string.compareTo(node.datum);
      if (compare < 0) node.left = insert(string, node.left);
      else if (compare > 0) node.right = insert(string, node.right);
      return node;
   }

   /**
    * Show the contents of the BST in alphabetical order.
    */
   public void show() {
      show(root);
      System.out.println();
   }

   private static void show(TreeCell<String> node) {
      if (node == null) return;
      show(node.left);
      System.out.print(node.datum + " ");
      show(node.right);
   }

   /**
    * toString. Prints a "sideways" version of the tree. The root is on the
    * left; left and right children correspond to down and up, respectively.
    */
   public String toString() {
      return toString("", root);
   }

   private static String toString(String prefix, TreeCell<String> node) {
      if (node == null) return "";
      String string = prefix + node.datum.toString();
      if (node.right != null)
         string = toString("    " + prefix, node.right) + "\n" + string;
      if (node.left != null)
         string = string + "\n" + toString("    " + prefix, node.left);
      return string;
   }
}

class TreeCell<T> {

   T datum;
   TreeCell<T> left, right;

   public TreeCell(T datum) {
      this.datum = datum;
      left = null;
      right = null;
   }
}
