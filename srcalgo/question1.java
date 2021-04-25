import java.util.ArrayList;
import java.util.List;

public class question1 {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int scoreA = 0, scoreB =0;
        List<Integer> scoreList = new ArrayList<>();

        for(int i =0;i<a.size();i++){
            if(a.get(i)>b.get(i)){
                scoreA++;
            }
            if (b.get(i) > a.get(i)){
                scoreB++;
            }
        }
        scoreList.add(scoreA);
        scoreList.add(scoreB);
            return scoreList;
    }

    public static void main(String[] args) {

    }
}
