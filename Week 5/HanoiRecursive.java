public class HanoiRecursive {
   
   public static void main (String[] args) {
      //move args[0] disks from tower 0 to tower 1
      move(Integer.parseInt(args[0]),0,1);
   }
   
   //move n disks from tower source to tower dest
   static void move(int n, int source, int dest) {
      if (n == 0) return;
      if (n == 1) {
         out(0, source, dest);
      } else {
         int third = 3 - (source + dest); //number of the third tower
         move(n-1, source, third);
         out(n-1, source, dest);
         move(n-1, third, dest);
      }  
   }
   
   static void out(int d, int source, int dest) {
      System.out.println("Moving disk " + d + " from tower " + source + " to tower " + dest);
   }
}
