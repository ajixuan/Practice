import java.util.function.Function;

/**
 * Problem:
 *  Given a list of coins of different values, what is the fewest number of coins needed to
 *  make up that amount?
 *
 * Dynamic Programming:
 *  - The solution is built up from computations of smaller problems
 *  - Grow from smaller problems to bigger problems
 *
 * Deal with subproblems first
 * how to sum 1 coin -> n coins
 * Each step is an array listing the minimum
 *
 */
public class CoinSum {

    /**
     * Find the remainder on a coin after optimal
     * @param coins
     * @param sum
     * @return
     */
    public int findRemainder(int[] coins, int sum){
        while (sum != 0) {
            int tok = 0;

            //Choose the largest possible coin
            tok = findLargestCoin(coins,sum);

            if(tok == -1) return sum;
            sum -= tok;
        }
        return sum;
    }

    /**
     * Find the biggest possible coin for the given sum
     *
     * @param sum
     * @return
     */
    public int findMinCoins(int[] coins,int sum) {
        int ans = 0;

        //If no coin is small enough for sum
        if(findLargestCoin(coins, sum) == -1) return -1;

        while (sum != 0) {
            //Choose the largest possible coin
            int coin = findLargestCoin(coins, sum);

            if(coin == -1) return ans;
            sum -= coin;
            ans++;
        }

        return ans;
    }

    private int findLargestCoin(int[] coins, int amount) {
        int tok = -1;
        for (int coin : coins) {
            if (coin <= amount && coin > tok) tok = coin;
        }
        return tok;
    }


    public int coinChange(int[] coins, int amount) {
        int[] solutions = new int[amount+1];
        if(amount == 0) return 0;
        int remainder = 0, reCompute, aggregateSol;

        for (int n = 0; n <= amount; n++) {
            if (n == 0) {
                solutions[n] = 0;
                continue;
            }

            //If there is remainder
            remainder = findRemainder(coins, n);
            reCompute = findMinCoins(coins, n);
            solutions[n] = reCompute;

            if(remainder != 0 && solutions[n-1] < 0){
                   solutions[n] = Math.min(reCompute, solutions[n-1] + findMinCoins(coins, remainder));
            }
        }
        return (remainder > 0) ? -1 : solutions[amount];
    }
}
