
public class BSTTest {
    
    public static BST tree; // An example (created by main())
    
    /**
     * Test program.
     */
    public static void main(String[] args) {
      BST t = new BST();
      tree = t;
      t.insert("jan");
      t.insert("feb");
      t.insert("mar");
      t.insert("apr");
      t.insert("may");
      t.insert("jun");
      t.insert("jul");
      t.insert("aug");
      t.insert("sep");
      t.insert("oct");
      t.insert("nov");
      t.insert("dec");
      System.out.println(t);
    }
}
