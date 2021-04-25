public class problem1 {
    //easy
    static int[] reverseArray(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length ; i++) {
            result[i] = a[(a.length-1)-i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] myArr = {1,2,3,4,5,6,7,8};
        int[] reversed = problem1.reverseArray(myArr);
        for (int value : reversed) {
            System.out.println(value);
        }
    }
}
