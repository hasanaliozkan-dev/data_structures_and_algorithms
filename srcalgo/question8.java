public class question8 {
    static String timeConversion(String s) {
        int hours = Integer.parseInt(s.substring(0,2));
        if (s.endsWith("AM") && s.startsWith("12"))
            return "00" + s.substring(2,s.length()-2);
        else if(s.endsWith("AM"))
            return s.substring(0,s.length()-2);
        else if (s.endsWith("PM")&&s.startsWith("12"))
            return s.substring(0,s.length()-2);
        return (hours+12) + ""+s.substring(2,s.length()-2);
    }

    public static void main(String[] args) {
        String mystr = "04:01:00PM";
        System.out.println(timeConversion(mystr));
    }

}
