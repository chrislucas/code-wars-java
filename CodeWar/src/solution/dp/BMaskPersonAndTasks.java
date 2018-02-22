package solution.dp;

/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 *
 * Problema:
 *
 * Seja N o numero de pessoas envolvidas em N tarefas, cada tarefa é atribuida para uma unica pessoa.
 * Tambem temos uma matriz de custo cost[N][N] onde a i-th pessoa cobrar pela j-esima tarefa cost[i][j];
 *
 *
 * Hungarian Algorithm
 * https://www.geeksforgeeks.org/hungarian-algorithm-assignment-problem-set-1-introduction/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/assignment-problem-and-hungarian-algorithm/
 *
 * */

public class BMaskPersonAndTasks {


    public static void assignBruteForce(int n, int cost [][]) {
        int [] tasks = new int[n];
        for (int i = 0; i < n; i++)
            tasks[i] = i;
        int limit = n;
        for (int i = n-1; i > 1 ; i--)
            limit *= i;
        int res = Integer.MAX_VALUE;


        for(int i=0; i<limit; i++) {
            int tCost = 0;
            for (int j = 0; j < n; j++) {
                tCost += cost[j][tasks[j]];
            }
        }
    }

    public static int countBits(int pp) {
        int bits = 0;
        while(pp>0) {
            pp &= (pp-1);
            bits++;
        }
        return bits;
    }

    public static int assignDpBitMask(int n, int cost [][]) {
        int [] memo = new int[1<<n];
        for (int i = 1; i < n; i++)
            memo[i] = Integer.MAX_VALUE;
        for(int i=0; i<(1<<n); i++) {
            int bits = countBits(i);
            for (int j = 0; j < n ; j++) {
                if( (i & 1 << j) == 0)
                    memo[i|(1<<j)] = memo[i|(1<<j)] < memo[i] + cost[bits][j] ? memo[i|(1<<j)] : memo[i] + cost[bits][j];
            }
        }
        return memo[1<<n-1];
    }

    public static void main(String[] args) {

    }

}
