class Solution {

    private int solve(String s, int idx, Integer[] dp) {
        if(idx == s.length()) {
            return 1;
        }

        if(dp[idx] != null) {
            return dp[idx];
        }

        if(s.charAt(idx) == '0') {
            dp[idx] = 0;
            return 0;
        }
            
        int total = solve(s, idx+1, dp);

        if(idx+1 < s.length()) {
            char tens = s.charAt(idx);
            char ones = s.charAt(idx+1);
            if((tens == '2' && ones <= '6') || tens < '2') {
                total += solve(s, idx+2, dp);
            }
        } 

        dp[idx] = total;
        
        return total;
    }

    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(s, 0, dp);
    }
}