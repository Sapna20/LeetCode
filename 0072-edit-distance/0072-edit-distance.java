class Solution {

    private int solve(String word1, String word2, int i, int j, int m, int n, Integer[][] memo) {
        if(i == m) {
            return n - j;
        } else if (j == n) {
            return m - i;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = solve(word1, word2, i+1, j+1, m, n, memo);
            return memo[i][j];
        }

        int insert = 1 + solve(word1, word2, i, j+1, m, n, memo);
        int delete = 1 + solve(word1, word2, i+1, j, m, n, memo);
        int replace = 1 + solve(word1, word2, i+1, j+1, m, n, memo);

        memo[i][j] = Math.min(insert, Math.min(delete, replace));
        return memo[i][j];
    } 

    public int minDistance(String word1, String word2) {
        int m =  word1.length(), n = word2.length();
        Integer[][] memo = new Integer[m][n];
        return solve(word1, word2, 0, 0, m, n, memo);
    }
}