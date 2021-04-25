public class problem5 {
    // Complete the matchingStrings function below.
    //medium
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        int i = 0;
        for (String a :queries) {
            int counter = 0;
            for (String b:strings) {
                if(a.equals(b)){
                    counter++;
                }

            }
            result[i] = counter;
            i++;
        }
        return result;
    }
}
