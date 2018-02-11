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
    private int[] coins;
    private int[] solutions;
    private int sum;

    public CoinSum(int[] coins, int sum){
       this.coins = coins;
       this.sum = sum;
       this.solutions = new int[sum+1];
    }


    public void setCoins(int[] coins){
        this.coins = coins;
    }

    public void setSum(int sum){
        this.sum = sum;
        this.solutions = new int[sum+1];
    }

    public int getCoinSum(){
        //Main loop
        for(int n = 0; n <= sum; n++){
            if(n == 0){
                this.solutions[n] = 0;
                continue;
            }

            //Get previous solutions to reduce problem size
            this.solutions[n] = Math.min(this.solutions[n-1] + this.findMinCoins(1), this.findMinCoins(n));
        }

        return this.solutions[sum];
    }

    /**
     * Find the biggest possible coin for the given sum
     * @param sum
     * @return
     */
    public int findMinCoins(int sum){
        int ans = 0;
        int tok = 0;
        while(sum != 0){
            //Choose the largest coin
            for(int coin : this.coins){
                if(coin <= sum){
                    tok = coin;
                }
            }
            sum-=tok;
            ans++;
        }

        return ans;
    }

}
