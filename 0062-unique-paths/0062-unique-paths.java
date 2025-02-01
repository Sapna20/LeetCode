class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<m+1; i++) {
            dp[i][0] = 0;
            if(i>=1) {
                dp[i][1] = 1;
            }
        }
        for(int j=0; j<n+1; j++) {
            dp[0][j] = 0;
            if(j>=1) {
                dp[1][j] = 1;
            }
        }

        for(int i=2; i<m+1; i++) {
            for(int j=2; j<n+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}