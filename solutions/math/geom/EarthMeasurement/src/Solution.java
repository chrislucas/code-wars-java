import static java.lang.Math.*;

public class Solution {

    /**
     * https://www.codewars.com/kata/5b036114de4c7facd70000d4/solutions/java
     * https://en.wikipedia.org/wiki/Eratosthenes
     * http://www.uff.br/webmat/Calc1_LivroOnLine/Cap14_Calc1.html
     * https://pt.wikipedia.org/wiki/Fun%C3%A7%C3%B5es_trigonom%C3%A9tricas_inversas
     * */

    // test troca de base
    private static double log(int lg, int base) {
        return log10(lg) / log10(base);
    }

    /**
     *
     * Como calcular um angulo sabendo 2 catetos
     *
     * arco tangente (cateto oposto / cateto adj) * 180 / PI
     *
     * Como calcular um angulo sabendo o cateto oposto e a hipotenusa
     *
     * arco seno (cateto oposto / hipotenusa) * 180 / PI
     *
     * */

    /**
     * https://www.codewars.com/kata/a-man-and-his-earthly-measurement/train/java
     * Eratosthenes e seu experimento para descobrir que a terra NAO EH PLANA
     * https://www.calculat.org/pt/area-perimetro/triangulo-retangulo.html
     * */
    public static double circumference(double rodHeight,double shadowLength,double distanceToWell)
    {
        double angle = atan(shadowLength/rodHeight) * 180 / PI;
        return round(360.0 / angle * distanceToWell);
    }


    public static double circumference2(double rodHeight,double shadowLength,double distanceToWell)
    {
        double angle = atan(shadowLength/rodHeight) ;
        return distanceToWell * 2 * PI / angle;
    }

    private static void test() {
        //System.out.println(tan(45 * PI / 180));
        System.out.println(asin(130.0/170.29) * 180 / PI);
        System.out.println(atan(110.0/130.0) * 180 / PI);
        /*

        System.out.println(circumference(25,18, 800));
        System.out.println(circumference(130,110, 800));
        */
    }

    public static void main(String[] args) {

        System.out.println(circumference(8.1,1.0, 800));
        System.out.println(circumference2(8.1,1.0, 800));
        System.out.println(circumference(1, 5, 20));
        System.out.println(circumference2(1, 5, 20));
        System.out.println(circumference(2, 5, 50));
        System.out.println(circumference2(2, 5, 50));


    }

}
