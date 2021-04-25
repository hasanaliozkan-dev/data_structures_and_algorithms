public class question27 {

    static int sockMerchant(int n, int[] ar) {
        int same = 0;
        for (int i = 0; i <ar.length; i++) {
            for (int j = i; j <ar.length ; j++) {
                if (ar[j]<ar[i]){
                    int temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                }
            }
        }
        int index = 0;
        while (index<ar.length){
            if (ar[index-1]==ar[index]){
                same++;
                index+=2;
            }
            else {
                index++;
            }
        }


        return same;
    }
}
