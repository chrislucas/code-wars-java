package solution.dp;

/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 * */
public class Bitmask {

    public static int setIthBit(int value, int ith) {
        return value | (1 << ith);
    }

    public static int unsetIthBit(int value, int ith) {
        return value &  ~(1 << ith);
    }

    public static boolean ithIsSet(int value, int ith) {
        return (value & (1 << ith)) > 0;
    }

    public static void testSetIthBit() {
        int c = 0;
        for(int i=0; i<31; i++) {
            c = setIthBit(c, i);
            System.out.println(c);
        }
        System.out.println(unsetIthBit(15, 3));
        System.out.println(ithIsSet(6, 1));
    }

    /**
     * Quantos subconjuntos de S quando somados atingem o valor t
     * */
    public static int countSubsetSummationEqualsT (int [] set, int target) {
        int acc = 0;
        for(int bit=0; bit <  (1 << set.length); bit++) {
            int sum = 0;
            for(int k=0; k<set.length; k++) {
                if(ithIsSet(bit, k))
                    sum += set[k];
            }
            if(sum == target)
                acc++;
        }
        return acc;
    }

    public static void main(String[] args) {
        //testSetIthBit();
        int [][] subsets = {
            {15,15,30,7,23,32,-2}   // soma == 30 => 4
            ,{10,20,30,-15, 5}      // soma == 15 => 2
        };
        int idx = 0;
        System.out.println(countSubsetSummationEqualsT(subsets[idx], 30));
        System.out.println(countSubsetSummationEqualsT(subsets[1], 15));
    }
}
