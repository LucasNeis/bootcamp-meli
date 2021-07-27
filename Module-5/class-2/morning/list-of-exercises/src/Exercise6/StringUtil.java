package Exercise6;

public class StringUtil {
    public static String lpad(String s, char c, int n) {
        String padding = "";
        for (int i = s.length()-1; i < n; i--) {
            padding += c;
        }
        return s;
    }

    public static String rpad(String s, char c, int n) {
        for (int i = 0; i < n; i++) {
            s += c;
        }
        return s;
    }

    public static String ltrim(String s) {
        int index = 0;
        while(s.charAt(index) == ' ')
            index++;
        return s.substring(index);
    }

    public static String rtrim(String s) {
        int index = s.length()-1;
        while(s.charAt(index) == ' ')
            index--;
        return s.substring(0, index+1);
    }

    public static String trim(String s) {
        s = ltrim(s);
        return rtrim(s);
    }

    public static int indexOfN(String s, char c, int n) {
        int index = -1;
        int count = 0;
        while(index+1 < s.length() && count < n) {
            index++;
            if(s.charAt(index) == c) {
                count++;
            }
        }
        return count == n ? index : -1;
    }
}
