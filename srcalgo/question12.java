import java.util.Arrays;

public class question12 {
    //medium
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int index = 0;
        int transmitter = 0;
        while(index < x.length){
            transmitter++;
            int location=x[index]+k;
            while(index<x.length && x[index]<=location){
                index++;
            }
            location = x[--index] +k;
            while (index<x.length&&x[index]<=location){
                index++;
            }
        }
        return transmitter;
    }

}
