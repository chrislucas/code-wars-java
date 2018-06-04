package solution.dp;

/**
 * https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/solutions/java
 * DONE
 * */

public class MaxSubarraySumI {
    
    public static int sequence(int [] arr) {
        int maxAcc = 0, curAcc = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(curAcc < 0)
                curAcc = 0;
            curAcc += arr[i];
            if(curAcc >  maxAcc)
                maxAcc = curAcc;
        }
        return maxAcc;
    }

    public static int [] sequencev3(int [] arr) {
        int  rs [] = new int [3], curAcc = 0;
        for (int i = 0; i < arr.length ; i++) {
            curAcc += arr[i];
            if(curAcc < 0) {
                curAcc = 0;
                rs[1] = i+1;
            }
            if(curAcc >  rs[0]) {
                rs[0] = curAcc;
                rs[2] = i;
            }
        }
        return rs;
    }

    public static int sequencev2(int [] arr) {
        int maxAcc = 0, curAcc = arr.length > 0 ? arr[0] : 0;
        for (int i = 1; i < arr.length ; i++) {
            curAcc = Math.max(arr[i], curAcc+arr[i]);
            maxAcc = Math.max(curAcc, maxAcc);
        }
        return maxAcc;
    }
    
    public static void main(String[] args) {
        int [][] matrix = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4}
            ,{}
            ,{-1,-2,-3,-5,-10,0}
            ,{-2, -3, 4, -1, -2, 1, 5, -3}
            ,{17, -31, 3, 23, 5, 19, -27, -42, -25, -26, -21, 2, 43, -5, 23}
            ,{3, -4, 8, 7, -10, 19, -3}
        };
        int idx = 5;
        System.out.println(sequence(matrix[idx]));
        System.out.println(sequencev2(matrix[idx]));

        int rs [] = sequencev3(matrix[idx]);
        System.out.printf("%d %d %d", rs[0], rs[1], rs[2]);
    }
}
