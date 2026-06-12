class Solution {

    private int solve(int amount, int[] coins, int idx, Integer[][] dp) {

        if(amount == 0) {
            dp[idx][amount] = 1;
            return 1;
        }

        if(idx < 0) {
            return 0;
        }

        if(dp[idx][amount] != null) {
            return dp[idx][amount];
        }

        if(amount - coins[idx] >= 0) {
            dp[idx][amount] = solve(amount - coins[idx], coins, idx, dp) + solve(amount, coins, idx-1, dp);
        } else {
            dp[idx][amount] = solve(amount, coins, idx-1, dp);
        }

        return dp[idx][amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        
        return solve(amount, coins, coins.length-1, dp);
    }
}