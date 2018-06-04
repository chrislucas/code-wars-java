public class Solution {

    /**
     * https://www.codewars.com/kata/regex-validate-pin-code/train/java
     * */

    public static boolean validatePin(String pin) {
        // Your code here...
        return pin.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        System.out.println(validatePin("1234"));
        System.out.println(validatePin("0000"));
        System.out.println(validatePin("1111"));
        System.out.println(validatePin("123456"));
        System.out.println(validatePin("098765"));
        System.out.println(validatePin("000000"));
        System.out.println(validatePin("090909"));


        System.out.println("\n\n");

        System.out.println(validatePin("1"));
        System.out.println(validatePin("-1"));
        System.out.println(validatePin("-1111"));
        System.out.println(validatePin("-111122"));
        System.out.println(validatePin("12"));
        System.out.println(validatePin("123"));
        System.out.println(validatePin("1234567"));
        System.out.println(validatePin("1234567"));
        System.out.println(validatePin("12345"));
        System.out.println(validatePin("a12345"));
        System.out.println(validatePin("a234"));
        System.out.println(validatePin("1.234"));
        System.out.println(validatePin("1 234  "));
    }
}
