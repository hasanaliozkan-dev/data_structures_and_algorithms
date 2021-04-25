import java.util.*;
import java.math.*;

public class question25 {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i)>=38){
                int mod = grades.get(i)%5;
                int difference = Math.abs(mod-5);
                if (difference<3){
                    grades.set(i,grades.get(i)+difference);
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        System.out.println(Math.floorMod(13,5));
    }

}
