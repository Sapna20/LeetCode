class Solution {

    public int solve(String s, int i, int[] dp) {
        if(i == s.length()) {
            dp[i] = 1;
            return 1;
        } else if(i > s.length()) {
            if(i==s.length()) {
                dp[i] = 0;
            }
            return 0;
        }
        if(dp[i]!= -1) {
            return dp[i];
        }

        if(s.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }
            
        int a = solve(s, i+1, dp);
        int b=0;
        if(i+1 < s.length()) {
            int num = Integer.parseInt(s.charAt(i) + ""+ s.charAt(i+1));
            if(num <= 26) {
                b = solve(s, i+2, dp);
            }
        }
        dp[i] = a+b;
        return dp[i];
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        for(int i=0; i<s.length()+1; i++) {
            dp[i] = -1;
        }
        return solve(s, 0, dp);
    }
}