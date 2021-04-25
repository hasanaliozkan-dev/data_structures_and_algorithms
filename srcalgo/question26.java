public class question26 {
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int[] newApples = new int[apples.length];
        int[] newOranges = new int[oranges.length];
        int oran = 0,app = 0;
        for (int i = 0; i <apples.length ; i++) {
            newApples[i] = apples[i] +a;
        }
        for (int i = 0; i <oranges.length ; i++) {
            newOranges[i] = oranges[i] +b;
        }
        for (int item: newApples) {
            if (s<=item && item <= t){
                app++;
            }
        }
        for (int item: newOranges) {
            if (s<=item && item <= t){
                oran++;
            }
        }
        System.out.println(app+"\n"+oran);

    }
}
