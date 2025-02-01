class Solution {

    private int recurSolve(int m, int n, int i, int j, int[][] dp) {
        if(i==m-1 && j==n-1) {
            return 1;
        } else if(i>=m || j>=n || j<0 || i<0) {
            return 0;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = recurSolve(m, n, i+1, j, dp) + recurSolve(m, n, i, j+1, dp);

        return dp[i][j];
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        return recurSolve(m, n, 0, 0, dp);
    }
}