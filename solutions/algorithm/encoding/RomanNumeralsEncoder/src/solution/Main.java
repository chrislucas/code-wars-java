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

    private String getChar(int n) {
        StringBuilder s = new StringBuilder();
        if (n > 1 && n < 5) {
            if (n == 4) {
                s.append("IV");
            }
            else {
                for (int i = 0; i < n ; i++) {
                    s.append("I");
                }
            }
        }

        else if (n > 5 && n < 10) {
            if (n == 9) {
                s.append("IX");
            }
            else {
                s.append("V");
                for (int i = 0; i < n ; i++) {
                    s.append("I");
                }
            }
        }

        else if (n > 10 && n < 100) {
            int d = n % 10;
            int u = n / 10;
        }

        else if (n > 100 && n < 1000) {

        }

        else {

        }

        return s.toString();
    }

    private String process(int m, int digits) {
        if (romanMap.containsKey(m))
            return romanMap.get(m);
        else {
            StringBuilder sb = new StringBuilder();
            int mutiple = (int)Math.pow(10, digits);
            while (m > 0) {
                int n = m - (m % mutiple);
                sb.append(getChar(n));
                mutiple /= 10;
            }
            return sb.toString();
        }
    }

    private int getQDigits(int n) {
        return (int) Math.log10(n);
    }

    public String solution(int n) {
        int e = getQDigits(n);
        int mutiple = (int)Math.pow(10, e);
        StringBuilder sb = new StringBuilder();
        while (n>9) {
            int o = n - (n % mutiple);
            sb.append(process(o, getQDigits(o)));
            mutiple /= 10;
            n -= o;
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
