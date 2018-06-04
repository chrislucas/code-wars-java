public class Solution {

    // https://www.codewars.com/kata/sum-of-two-integers/train/java


    private static int add(int x, int y)
    {
       while (y != 0) {
           //
           int carry = x & y;
           //
           x ^= y;
           //
           y = carry << 1;
       }
       return x;
    }


    private static int addRec(int x, int y) {
        return (y == 0) ? x : addRec(x ^ y, (x & y) << 1);
    }

    public static void main(String[] args) {
        System.out.println(add(5,3));
        System.out.println(addRec(5,3));
        System.out.println(add(15,1));
        System.out.println(addRec(15,1));
        System.out.println(add(5,5));
        System.out.println(addRec(5,5));
        System.out.println(add(4,2));
        System.out.println(addRec(4,2));
        System.out.println(add(22,-22));
        System.out.println(addRec(22,-22));
        System.out.println(add(-22,-22));
        System.out.println(addRec(-22,-22));
    }
}
