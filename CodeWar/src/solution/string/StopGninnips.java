package solution.string;

import java.util.StringTokenizer;

/**
 * https://www.codewars.com/kata/stop-gninnips-my-sdrow/train/java
 * */

public class StopGninnips {

    public static String spinWords(String sentence) {
        StringTokenizer tk = new StringTokenizer(sentence, " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; tk.hasMoreTokens(); i++) {
            if(i > 0) {
                sb.append(" ");
            }
            String token = tk.nextToken();
            if(token.length() > 4) {
                StringBuilder reverse = new StringBuilder();
                for(int k=token.length()-1; k>-1; k--) {
                    reverse.append(token.charAt(k));
                }
                sb.append(reverse.toString());
            } else {
                sb.append(token);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
        System.out.println(spinWords("This is a test"));
        System.out.println(spinWords("This is another test"));
        System.out.println(spinWords("Welcome"));
    }
}
