class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[n] = 1;
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i)!='0') {
                dp[i] = dp[i+1];
                if(i+1 < n) {
                    int num = Integer.parseInt(s.charAt(i) + ""+ s.charAt(i+1));
                    if(num <= 26) {
                        dp[i] += dp[i+2];
                    }
                }
            } else {
                dp[i] = 0;
            }
        }
        
        return dp[0];

    }
}