import java.util.ArrayList;
import java.util.List;

public class question7 {

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 1,total=0;//neden bu kadar uzun sürdüğünü anlamadım.
        for (Integer integer : candles) {
            if (max < integer)
                max = integer;
        }
        for (Integer candle: candles) {
            if (candle == max)
                total++;

        }
        return total;
    }
    public static void main(String[] args) {
        List<Integer> candle = new ArrayList<>();
        candle.add(3);
        candle.add(2);
        candle.add(1);
        candle.add(3);

        System.out.println(birthdayCakeCandles(candle));

    }
}
