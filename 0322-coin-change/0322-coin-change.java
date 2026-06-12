class Solution {

    private int solve(int[] coins, int amount, int idx, Integer[][] dp) {
        if(amount <= 0) {
            return 0;
        }
        if(idx < 0) {
            return 10001;
        }

        if(dp[idx][amount] != null) {
            return dp[idx][amount];
        }

        if(amount - coins[idx] >= 0) {
            dp[idx][amount] = Math.min(
                1 + solve(coins, amount - coins[idx], idx, dp),
                solve(coins, amount, idx-1, dp)
                );
            return dp[idx][amount];
        }

        dp[idx][amount] = solve(coins, amount, idx-1, dp);
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];

        int count = solve(coins, amount, coins.length-1, dp);

        System.out.println(Integer.MAX_VALUE);
        return count > 10000 ? -1 : count;

        // during revision write bottom up approach
    }
}