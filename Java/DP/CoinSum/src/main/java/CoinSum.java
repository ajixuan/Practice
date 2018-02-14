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
 *      How to sum 1 coin -> n coins
 *      Each step is an array listing the minimum
 *
 * Problem:
 * Do not use the method of using the largest coin, that is the naive method and is actually the
 * opposite of dynamic programming. If you are doing that then you have not learned how to do
 * dynamic programming at all
 *
 * Solve the easier problems first, and build up the big problem by recursively finding the solution of easier problems
 *
 */
public class CoinSum {

    public int coinChange(int[] coins, int amount) {
        int[] solutions = new int[amount+1];
        if(amount == 0) return 0;
        solutions[0] = 0;

        //Solving the problem one cent at a time
        for (int n = 1; n <= amount; n++) {
            solutions[n] = -1;

            //Check if there are coins smaller
            for(int coin : coins) {

                //For all coins smaller than current amount
                if(coin <= n) {

                    //Do not look for sums where no solution exist
                    if(n - coin >= 0 && solutions[n - coin] >= 0) {

                        //We do +1 for the solution because subtract our
                        int prevSol = solutions[n - coin] + 1;

                        //If previous coin already assigned a solution
                        if(solutions[n] != -1) {
                            solutions[n] = Math.min(solutions[n], prevSol);
                            continue;
                        }

                        solutions[n] = prevSol;
                    }
                }
            }
        }

        return solutions[amount];
    }
}
