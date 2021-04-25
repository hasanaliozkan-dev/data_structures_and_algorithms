import java.math.BigInteger;
import java.util.*;

public class question13 {
    //medium
    static BigInteger gridlandMetro(long n, long m, int k, long[][] track) {
        if (k == 0) {
            return BigInteger.valueOf(n*m);
        }
        Arrays.sort(track, new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                if (a[0] == b[0]) {
                    if (a[1] < b[1]) return -1;
                    else if (a[1] > b[1]) return 1;
                    else return 0;
                }
                else {
                    if (a[0] < b[0]) return -1;
                    if (a[0] > b[0]) return 1;
                    else return 0;
                }
            }
        });
        long len = (track[0][2] - track[0][1] + 1);
        long oldC2 = track[0][2];

        for (int i = 1; i < track.length; i++) {
            long c1 = track[i][1];
            long c2 = track[i][2];

            if (track[i-1][0] != track[i][0]) {
                len += (c2 - c1 + 1);
                oldC2 = c2;
            }
            else {
                if (c1 <= oldC2) {
                    len += (Math.max(c2, oldC2) - oldC2);
                }
                else {
                    len += (c2 - c1 + 1);
                }
                oldC2 = Math.max(c2, oldC2);
            }
        }

        return BigInteger.valueOf(n*m - len);
    }


    public static void main(String[] args) {

    }
}
