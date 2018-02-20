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
        else if(weights[i] > capacity)
            return solverTopDown(capacity, weights, values, i-1);
        /**
         * se o objeto nao excede a capacidade verificamos obtemos o valor maximo
         * incluindo na solucao ou nao
         * */
        else {
            int p = Integer.MAX_VALUE, q = Integer.MAX_VALUE;
            // incluir o i-esimo objeto
            p = values[i] + solverTopDown(capacity - weights[i], weights, values, i-1);
            // ou nao
            q = solverTopDown(capacity, weights, values, i-1);
            return p > q ? p : q;
        }
    }


    /**
     * Versao que indica quais objetos foram escolhidos
     * */
    public static int solverTopDown(int capacity, int weights[]
            , int values [], boolean [] objects, int i) {
        if(i == 0 || capacity == 0)
            return 0;
        else if(weights[i] > capacity)
            return solverTopDown(capacity, weights, values, objects, i-1);
        else {
            int p = Integer.MAX_VALUE, q = Integer.MAX_VALUE;
            // incluir o i-esimo objeto
            p = values[i] + solverTopDown(capacity - weights[i], weights, values, objects, i-1);
            // ou nao
            q = solverTopDown(capacity, weights, values, objects, i-1);
            if(p > q)
                objects[i] = true;
            return p > q ? p : q;
        }
    }

    /**
     *
     * */
    public static int solverBottomUp(int capacity, int weights[], int values [], boolean [] objects) {
        int l = objects.length, c = capacity + 1;
        int memo [][] = new int[l][c];
        for (int i = 0; i < l ; i++) {
            for (int j = 0; j < c; j++) {
                
            }
        }

        return memo[l-1][c];
    }


    public static void test1() {
        int [] cap = {3, 50};
        int [][] weights = {
            {3,1,2}
            ,{10,20,30}
        }
        , values = {
             {5,3,3}
            ,{60,100,120}
        };
        int idx = 0;
        //System.out.println(solverTopDown(cap, weights, values, 2));
        boolean [] objects = new boolean[weights[idx].length];
        System.out.println(solverTopDown(cap[idx], weights[idx], values[idx], objects,2));
        for(int i=0; i<objects.length; i++) {
            if(objects[i])
                System.out.printf("%d ", i);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        test1();
    }
}
