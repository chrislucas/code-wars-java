package solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/sieve-of-eratosthenes/train/java
 *  *                  n     Primes <= n
 *  ---------------------------------
 *                 10               4
 *                100              25
 *              1,000             168
 *             10,000           1,229
 *            100,000           9,592
 *          1,000,000          78,498
 *         10,000,000         664,579
 *        100,000,000       5,761,455
 *      1,000,000,000      50,847,534
 *
 *      DONE
 * */

public class SieveEratosthenes {

    static public List<Integer> Primes(Integer x) {
        x++;
        List<Integer> results = new ArrayList<>();
        boolean[] f = new boolean[x];
        for(int i=2; i<x; i++)
            f[i] = true;

        for (int i = 2; i*i<=x; i++) {
            if(f[i]) {
                for (int j=i*i; j<x; j+=i) {
                    f[j] = false;
                }
            }
        }

        for(int i=0; i<x; i++) {
            if(f[i])
                results.add(i);
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(Primes(3).size());
    }
}
