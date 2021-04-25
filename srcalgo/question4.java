public class question4 {

    static void plusMinus(int[] arr) {
        double positive=0,negative=0;
        for (int item:arr) {
            if(item > 0)
                positive++;
            if (item<0)
                negative++;
        }
        System.out.println(positive/arr.length);
        System.out.println(negative/arr.length);
        System.out.println((arr.length-(positive+negative))/arr.length);
    }

    public static void main(String[] args) {
        int[] myarr = {1,2,3,4,5,6,-7,-8,-9,0};
        question4.plusMinus(myarr);
    }
}
