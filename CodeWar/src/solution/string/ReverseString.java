package solution.string;

/**
 * https://www.codewars.com/kata/recursive-reverse-string/train/java
 **/

public class ReverseString {

    public static int count = 0;
    public static String reverse(String str) {
        int len = str.length();
        if(len < 1)
            return str;
        String subs = str.substring(len-(len-1), len);
        count++;
        String out = reverse(subs);
        out += String.format("%s", str.substring(0, 1));
        if(len == count) {
            count = 0;
            out = String.format("\"%s\" (N = %d)", out, len);
        }
        return out;
    }

    public static void main(String[] args) {
        //System.out.println(reverse("Hello World Christoffer Lucas"));
        System.out.println(reverse("hello world"));
        System.out.println(reverse("12345"));
        System.out.println(reverse("ab"));
    }

}
