class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int k=0; k<n; k++) {
            for(int j=k, i=0; j<n && i<n-k; j++,i++) {
                if(i==j || (j==i+1 && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}