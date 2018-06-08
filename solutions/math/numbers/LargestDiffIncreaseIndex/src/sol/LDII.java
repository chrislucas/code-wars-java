package sol;


/**
 * https://www.codewars.com/kata/largest-difference-in-increasing-indexes/train/java
 * DONE
 * */
public class LDII {


    public static int largestDifference(int[] data) {
        int acc = 0;
        int len = data.length;
        for (int i = 0; i <len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (data[i] <= data[j] && j-i > acc)
                    acc = j-i;
            }
        }
        //code here
        return acc;
    }

    public static void main(String[] args) {

    }
}
