package solution;


import java.util.LinkedHashMap;

/**
 * http://www.codewars.com/kata/roman-numerals-encoder/train/java
 * DONE
 **/

public class Main {

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

    private int getQDigits(int n) {
        return (int) Math.log10(n);
    }

    private String getChar(int n) {
        StringBuilder s = new StringBuilder();
        if (n > 1 && n < 10) {
            if (n < 4) {
                for (int i = 0; i < n ; i++) {
                    s.append("I");
                }
            }
            else if (n == 4) {
                s.append("IV");
            }
            else if(n > 5 && n < 9) {
                s.append("V");
                for (int i = 0; i < n-5 ; i++) {
                    s.append("I");
                }
            }
            else {
                s.append("IX");
            }
        }
        else if (n > 9 && n < 100) {
            int u = (n % 10);
            int c = n - u;
            int d = n/10;
            if (c < 40) {
                for (int i = 0; i<d ; i++) {
                    s.append("X");
                }
            }
            else if (c == 40) {
                s.append("XL");
            }
            else if (c < 90) {
                s.append("L");
                for (int i = 0; i<d-5; i++) {
                    s.append("X");
                }
            }

            else {
                s.append("XC");
            }

            if (u > 0)
                s.append(getChar(u));
        }
        else if (n > 99 && n < 1000) {
            int d = n % 100;
            int c = n - d;
            if (c < 400) {
                for (int i = 0; i < c/100 ; i++) {
                    s.append("C");
                }
            }
            else if (c == 400) {
                s.append("CD");
            }

            else if (c < 900) {
                s.append("D");
                for (int i = 0; i < c/100-5; i++) {
                    s.append("C");
                }
            }
            else {
                s.append("CM");
            }

            if (d > 0) {
                s.append(getChar(d));
            }
        }
        else {
            for (int i = 0; i < n/1000 ; i++) {
                s.append("M");
            }
        }
        return s.toString();
    }

    private String process(int m, int digits) {
        if (romanMap.containsKey(m))
            return romanMap.get(m);
        else {
            StringBuilder sb = new StringBuilder();
            int mutiple = (int) Math.pow(10, digits);
            while (m > 9) {
                int n = m - (m % mutiple);
                sb.append(getChar(n));
                mutiple /= 10;
                m -= n;
            }
            return m == 0 ? sb.toString() : sb.append(getChar(m)).toString();
        }
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
        return n == 0 ? sb.toString() : sb.append(process(n, 1)).toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 1; i < 4000 ; i++) {
            System.out.printf("%d %s\n", i, main.solution(i));
        }
        /*
        main.solution(17234);
        main.solution(17000);
        main.solution(1700);
        main.solution(170);
        */
    }
}
