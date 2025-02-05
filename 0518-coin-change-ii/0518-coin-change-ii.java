class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[m+1][n+1];

        for(int j=1; j<=n; j++) {
            dp[0][j] = 1;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i-coins[j-1] >= 0) {
                    dp[i][j] = dp[i-coins[j-1]][j] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}