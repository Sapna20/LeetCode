class Solution {

    private int solveBottomUp(String text1, String text2, int n) {
        int[][] dp = new int[n+1][n+1];
        int maxSoFar = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(maxSoFar < dp[i][j]){
                        maxSoFar = dp[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return maxSoFar;
    }

    private String reverseString(String s) {
        String temp = "";
        for(int i=0; i<s.length(); i++) 
            temp = s.charAt(i) + temp;

        return temp;
    }


    public int longestPalindromeSubseq(String s) {
        String sReverse = reverseString(s);
        int n = s.length();
        return solveBottomUp(s, sReverse, n);
    }
}