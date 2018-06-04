
import static  java.lang.Math.log10;

public class Solution {

    /**
     * https://www.codewars.com/kata/disarium-number-special-numbers-series-number-3
     * DONE
     * */

    private static final int countDigits(int n) {
        return (int) (log10(n) + 1);
    }

    private static int expBySquaring(int base, int expo) {
        int acc = 1;
        while (expo > 0) {
            if ( (expo & 1) == 1) {
                acc *= base;
            }
            base *= base;
            expo >>= 1;
        }
        return acc;
    }

    private static String disariumNumber(int number) {
        int digits = countDigits(number);
        int acc = 0;
        int copyNumber = number;
        while (copyNumber > 0) {
            int digit = copyNumber % 10;
            copyNumber /= 10;
            acc += expBySquaring(digit, digits);
            digits--;
        }
        return number == acc ? "Disarium !!" : "Not !!";
    }

    private static void testDigits() {
        System.out.println(countDigits(1048576));
        System.out.println(countDigits(136586));
        System.out.println(countDigits(564));
        System.out.println(countDigits(89));
        System.out.println(countDigits(64599));
        System.out.println(countDigits(1024));
    }

    private static void testExpBySquaring() {
        System.out.println(expBySquaring(15, 5));
        System.out.println(expBySquaring(12, 4));
    }

    private static void testDisariumNumber() {
        System.out.println(disariumNumber(89));
        System.out.println(disariumNumber(564));
        System.out.println(disariumNumber(1024));
        System.out.println(disariumNumber(64599));
        System.out.println(disariumNumber(136586));
        System.out.println(disariumNumber(1048576));
    }

    public static void main(String[] args) {
        testDisariumNumber();
    }
}
