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
    private static int solverBottomUp(int capacity, int weights[], int values [], boolean [] objects) {
        int l = objects.length;
        int memo [][] = new int[l+1][capacity+1];
        for (int object = 0; object <= l ; object++) {
            for (int weight = 0; weight <= capacity; weight++) {
                if(object==0 || weight==0)
                    memo[object][weight] = 0;
                else if(weights[object-1] <= weight) {
                    int o = values[object-1] + memo[object-1][weight-weights[object-1]];
                    memo[object][weight] = o > memo[object-1][weight] ? o : memo[object-1][weight];
                }
                else {
                    memo[object][weight] = memo[object-1][weight];
                }
            }
        }
        return memo[l][capacity];
    }

    private static int solverBottomUpV2(int capacity, int weights[], int values [], boolean [] objects) {
        int l = objects.length;
        /**
         * Matriz bidimensional de estados.
         *
         * As listas representam a quantidade de objetos usados para resolver os subproblemas
         * do problema da mochila 0-1
         *
         * o loop abaixo comeca com 1 o que quer dizer que comecamos usando 1 objeto do vetor
         * values[] e aumentamos a qauntidade ate os N objetos dispostos nesse problema
         * */
        int memo [][] = new int[l+1][capacity+1];
        for(int i=0; i<capacity+1; i++)
            memo[0][i] = 0;
        for (int qObjects = 1; qObjects<=l ; qObjects++) {
            for (int weight=1; weight <=capacity; weight++) {
                if(weights[qObjects-1] <= weight) {
                    int cow = weight-weights[qObjects-1];
                    int o = values[qObjects-1] + memo[qObjects-1][cow];
                    memo[qObjects][weight] = o > memo[qObjects-1][weight] ? o : memo[qObjects-1][weight];
                }
                else {
                    memo[qObjects][weight] = memo[qObjects-1][weight];
                }
            }
        }
        return memo[l][capacity];
    }

    private static void testTopDown1() {
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
        System.out.println("");
    }

    private static void testBottomUp1() {
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
        boolean [] objects = new boolean[weights[idx].length];
        System.out.println(solverBottomUpV2(cap[idx], weights[idx], values[idx], objects));
        for(int i=0; i<objects.length; i++) {
            if(objects[i])
                System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        testBottomUp1();
    }
}
