class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];

        return solve(m-1, n-1, dp); 
    }

    private int solve(int m, int n, Integer[][] dp) {
        if(m == 0 || n == 0) {
            return 1;
        }

        if(dp[m][n] != null) {
            return dp[m][n];
        }

        dp[m][n] = solve(m-1, n, dp) + solve(m, n-1, dp);

        return dp[m][n];
    }
}