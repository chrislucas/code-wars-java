package solution;


import java.util.LinkedHashMap;

public class Main {

    /**
     * http://www.codewars.com/kata/roman-numerals-encoder/train/java
     **/

    static final LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();

    static {
        romanMap.put(1, "I");
        romanMap.put(5, "V");
        romanMap.put(10, "X");
        romanMap.put(50, "L");
        romanMap.put(100, "C");
        romanMap.put(500, "D");
        romanMap.put(1000, "M");
    }

    private String process(int m, int digits) {
        if (romanMap.containsKey(m))
            return romanMap.get(m);
        else {
            StringBuilder sb = new StringBuilder();
            return sb.toString();
        }
    }

    private int getDigits(int n) {
        return (int) Math.log10(n);
    }

    public String solution(int n) {
        int e = getDigits(n);
        int digits = (int)Math.pow(10, e);
        StringBuilder sb = new StringBuilder();
        while (n>9) {
            int m = n - (n % digits);
            sb.append(process(m, getDigits(m)));
            digits /= 10;
            n -= m;
        }
        return sb.append(process(n, 1)).toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.solution(17234);
        main.solution(17000);
        main.solution(1700);
        main.solution(170);
    }
}
