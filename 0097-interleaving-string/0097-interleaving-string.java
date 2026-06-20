class Solution {

    private boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if(i == s1.length() && j == s2.length()) {
            return true;
        }

        if(k == s3.length()) {
            return false;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k) && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            memo[i][j] = solve(s1, s2, s3, i+1, j, k+1, memo) || solve(s1, s2, s3, i, j+1, k+1, memo);
        } else if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            memo[i][j] = solve(s1, s2, s3, i+1, j, k+1, memo);
        } else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            memo[i][j] = solve(s1, s2, s3, i, j+1, k+1, memo);
        } else {
            memo[i][j] = false;
        }

        return memo[i][j];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] memo = new Boolean[s1.length()+1][s2.length()+1];
        return s1.length() + s2.length() == s3.length() && solve(s1, s2, s3, 0, 0, 0, memo);
    }
}