class Solution {

    private int solve(String text1, String text2, int m, int n, Integer[][] dp) {
        if(m < 0 || n < 0) {
            return 0;
        }

        if(dp[m][n] != null) {
            return dp[m][n];
        }

        if(text1.charAt(m) == text2.charAt(n)) {
            dp[m][n] = 1 + solve(text1, text2, m-1, n-1, dp);
        } else {
            dp[m][n] = Math.max(
                    solve(text1, text2, m-1, n, dp),
                    solve(text1, text2, m, n-1, dp)
                );
        }

        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        Integer[][] dp = new Integer[m][n];

        return solve(text1, text2, m-1, n-1, dp);
    }
}