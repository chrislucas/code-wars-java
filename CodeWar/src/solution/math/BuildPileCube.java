package solution.math;

/**
 * https://www.codewars.com/kata/build-a-pile-of-cubes/train/java
 * DONE
 * */

public class BuildPileCube {

    public static long findNb(long m) {
        double c = -Math.sqrt(m) * 2;
        long delta = Math.round(Math.sqrt(1-4*c));
        double b = (1-4*c);
        if( (delta*delta != b) )
            return -1;
        else {
            long p = delta/2;
            return (p*p+p)/2 * (p*p+p)/2 == m ? p : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNb(55100));
        System.out.println(findNb(2002639899491560001L));
        System.out.println(findNb(1071225));
        System.out.println(findNb(91716553919377L));
        System.out.println(findNb(2159263805881409957L));
        System.out.println(findNb(2163249598386669156L));
        System.out.println(findNb(3153));
        System.out.println(findNb(4183059834009L));
        System.out.println(findNb(24723578342962L));
        System.out.println(findNb(135440716410000L));
        System.out.println(findNb(40539911473216L));
    }
}
