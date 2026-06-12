class Solution {

    private boolean isValidMove(int i, int j, int m, int n) {
        return i <= m && i>=0 && j<=n && j>=0;
    }

    private int solve(int i, int j, int m, int n, Integer[][] dp) {

        if(!isValidMove(i, j, m, n)) {
            return 0;
        }

        if(dp[i][j] != null)
            return dp[i][j];


        if(i == m && j == n) {
            return 1;
        }

        dp[i][j] = solve(i+1, j, m, n, dp) + solve(i, j+1, m, n, dp);

        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return solve(0, 0, m-1, n-1, dp);
    }
}