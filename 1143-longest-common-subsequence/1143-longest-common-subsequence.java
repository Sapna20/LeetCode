class Solution {

    // Recursive - time limit exceeds 
    private int solveRecursive(String text1, String text2, int i, int j) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + solveRecursive(text1, text2, i-1, j-1);
        } else {
            return Math.max(
                solveRecursive(text1, text2, i, j-1),
                solveRecursive(text1, text2, i-1, j)
            );
        }
    }

    // memoization - takes space in stack for every method call
    private int solveMemo(String text1, String text2, int i, int j, int[][] dp) {
        if(i<0 || j<0) 
            return 0;
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + solveMemo(text1, text2, i-1, j-1, dp);
        } else {
            dp[i][j] = Math.max(
                solveMemo(text1, text2, i, j-1, dp),
                solveMemo(text1, text2, i-1, j, dp)
            );
        }

        return dp[i][j];
    }

    private int solveBottomUp(String text1, String text2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // return solveRecursive(text1, text2, m-1, n-1);

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        // return solveMemo(text1, text2, m-1, n-1, dp);

        return solveBottomUp(text1, text2, m, n);
    }
}