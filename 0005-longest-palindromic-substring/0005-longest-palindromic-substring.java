class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;

        for(int k=0; k<n; k++) {
            for(int i=0, j=k; i<n-k && j<n; i++, j++) {
                if(i == j || 
                    (j == i+1 && s.charAt(i) == s.charAt(j)) || 
                    (dp[i+1][j-1] && s.charAt(i) == s.charAt(j))    
                ) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                } 
            }
        }

        return s.substring(start, end+1);
    }
}