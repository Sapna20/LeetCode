class Solution {

    private int solveRecursive(int[] coins, int amount, int index, int[][] dp) {
        if(amount == 0) 
            return 0;
            
        if(index < 0) 
            return Integer.MAX_VALUE-12;
        
        if(dp[index][amount] != -1)
            return dp[index][amount];

        if(amount - coins[index] >= 0) {
            dp[index][amount] = Math.min(
                1+solveRecursive(coins, amount - coins[index], index, dp),
                solveRecursive(coins, amount, index - 1, dp)
            );
        } else {
            dp[index][amount] = solveRecursive(coins, amount, index-1, dp);
        }

        return dp[index][amount];
    }

    private int solveBottomUp(int[] coins, int amount, int n, int[][] dp) {
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        for(int j=1; j<=amount; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=amount; j++) {
                if(j-coins[i-1] >= 0) {
                    dp[i][j] = Math.min(
                        1 + dp[i][j-coins[i-1]],
                        dp[i-1][j]
                    );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=amount; j++) {
                dp[i][j] = -1;
            }
        }
        
        // int ans = solveRecursive(coins, amount, n-1, dp);

        int[][] dp2 = new int[n+1][amount+1];
        int ans = solveBottomUp(coins, amount, n, dp2);

        return ans >= Integer.MAX_VALUE-1 ? -1 : ans;
    }
}