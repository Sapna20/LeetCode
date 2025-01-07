class Solution {

    private int solveRecursive(int[] nums, int start, int end) {
        if(start > end) {
            return 0;
        }

        return Math.max(nums[start] + solveRecursive(nums, start+2, end), solveRecursive(nums, start+1, end));
    }

    private int solveMemo(int[] nums, int start, int end, int dp[]) {
        if(start > end) {
            return 0;
        }

        if(dp[start] != -1) 
            return dp[start];
        
        dp[start] = Math.max(nums[start] + solveMemo(nums, start+2, end, dp),
                         solveMemo(nums, start+1, end, dp));
        
        return dp[start];
    }

    private void refreshDP(int[] dp) {
        for(int i=0; i<dp.length; i++)
            dp[i] = -1;
    }

    private int solveBottomUp(int[] nums, int start, int n) {
        int[] dp = new int[n+2];
        
        for(int i=n-1; i>=start; i--) 
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        
        return dp[start];
    }

    public int rob(int[] nums) {
       
        // return Math.max( nums[0],
        // Math.max(solveRecursive(nums, 0, nums.length-2),
        //             solveRecursive(nums, 1, nums.length-1))
        // );

        // int[] dp = new int[nums.length];
        // refreshDP(dp);
        
        // int a = solveMemo(nums, 0, nums.length-2, dp);
        // refreshDP(dp);
        // int b = solveMemo(nums, 1, nums.length-1, dp);

        // return Math.max(nums[0], Math.max(a, b));

        int a = solveBottomUp(nums, 0, nums.length-1);
        int b = solveBottomUp(nums, 1, nums.length);

        return Math.max(nums[0], Math.max(a, b));

    }
}