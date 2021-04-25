public class question28 {
    public static int countingValleys(int steps, String path) {
     int seeLevel = 0,valley = 0;

        for (int i = 0; i <steps ; i++) {
            if (path.charAt(i) == 'U')
                seeLevel++;
            if (path.charAt(i) == 'D')
                seeLevel--;

            if (path.charAt(i) == 'U' && seeLevel==0)
                valley++;

        }
     return valley;
    }

}
