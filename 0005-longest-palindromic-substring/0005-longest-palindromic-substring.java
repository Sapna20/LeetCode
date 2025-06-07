class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for(int k=n-1; k>=0; k--) {
            for(int i=0, j=n-1-k; i<=k && j<=n-1; i++, j++) {
                
                if(i == j) {
                    dp[i][j] = true;
                } else if( i+1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]) {
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }
}