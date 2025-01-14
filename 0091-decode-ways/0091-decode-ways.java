class Solution {

    private int solveRecursive(String s, int index, int[] dp) {
        if (index < 0) {
            return 1;
        }

        if(dp[index] != -1) 
            return dp[index];

        int a=0, b=0;
        int num; 

        if(index - 1 >= 0) {
            num = Integer.parseInt(s.substring(index-1, index+1));
        } else {
            num = Integer.parseInt(s.substring(index, index+1));
        }

        if(num % 10 > 0) {
            a = solveRecursive(s, index-1, dp);
        }
        if(num >= 10 && num <= 26)
        {
            b = solveRecursive(s, index-2, dp);
        }

        dp[index] = a+b;
        
        return dp[index];
    }

    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n]; 

        for(int i=0; i<n; i++) 
            dp[i] = -1;

        return solveRecursive(s, n-1, dp);
    }
}