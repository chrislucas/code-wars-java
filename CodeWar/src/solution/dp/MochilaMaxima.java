package solution.dp;

/**
 * Mais uma vez um estudo do problema de programação da mochila de capacidade maxima
 * :)
 * :(
 *
 *
 * */

public class MochilaMaxima {

    public static int solverTopDown(int capacity, int weights[], int values [], int i) {
        /**
         * chegamos ao ultimo item ou atingimos a capacidade maxima
         * */
        if(i == 0 || capacity == 0)
            return 0;

        /**
         * Se o peso do i-esimo item excede a capacidade, nao o utilizaremos
         * na solucao do subproblema
         * */

        int p = Integer.MAX_VALUE, q = Integer.MAX_VALUE;

        if(weights[i] > capacity)
            solverTopDown(capacity, weights, values, i-1);
        /**
         * se o objeto nao excede a capacidade verificamos obtemos o valor maximo
         * incluindo na solucao ou nao
         * */
        else {
            // incluir o i-esimo objeto
            p = values[i] + solverTopDown(capacity - weights[i], weights, values, i-1);
            // ou nao
            q = solverTopDown(capacity, weights, values, i-1);
        }
        return Math.max(p, q);
    }


    /**
     * Versao que indica quais objetos foram escolhidos
     * */
    public static int solverTopDown(int capacity, int weights[]
            , int values [], boolean [] objects, int i) {
        /**
         * chegamos ao ultimo item ou atingimos a capacidade maxima
         * */
        if(i == 0 || capacity == 0)
            return 0;

        /**
         * Se o peso do i-esimo item excede a capacidade, nao o utilizaremos
         * na solucao do subproblema
         * */

        int p = Integer.MAX_VALUE, q = Integer.MAX_VALUE;

        if(weights[i] > capacity)
            solverTopDown(capacity, weights, values, objects, i-1);
        /**
         * se o objeto nao excede a capacidade verificamos obtemos o valor maximo
         * incluindo na solucao ou nao
         * */
        else {
            // incluir o i-esimo objeto
            p = values[i] + solverTopDown(capacity - weights[i], weights, values, objects, i-1);
            // ou nao
            q = solverTopDown(capacity, weights, values, i-1);
        }
        return Math.max(p, q);
    }


    public static void test1() {
        int cap = 3;
        int [] weights = {3,1,2}, values = {5,3,3};
        System.out.println(solverTopDown(cap, weights, values, 2));

        boolean [] objects = new boolean[weights.length];
        System.out.println(solverTopDown(cap, weights, values, objects,2));
    }

    public static void main(String[] args) {
        test1();
    }
}
