public class Power {
   
   public static void main(String[] args) {
      int val = Integer.parseInt(args[0]);
      int pow = Integer.parseInt(args[1]);
      System.out.println(power1(val, pow));
      System.out.println(power2(val, pow));
   }
   
   static int power1(int x, int p) {
      if (p == 0) return 1;
      else return x * power1(x, p - 1);
   }
   
   static int power2(int v, int p) {
      if (p == 0) return 1;
      int halfPower = power2(v, p/2);
      int evenPower = halfPower * halfPower;
      if (p % 2 == 0) return evenPower;
      return evenPower * v;
   }
} 


