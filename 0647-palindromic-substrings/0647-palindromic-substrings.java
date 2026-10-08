class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int k=0; k<n; k++) {
            for(int i=0, j=k; i<n-k && j<n; i++, j++) {
                if(i == j) {
                    dp[i][j] = true;
                    count++;
                } else if( j == i+1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                } else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}