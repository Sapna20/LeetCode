class Solution {

    private int solve(int[] nums, int start, int n, Integer[] dp) {
        if(n < start) {
            return 0;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        dp[n] = Math.max(
            nums[n] + solve(nums, start, n-2, dp),
            solve(nums, start, n-1, dp)
            );
        
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }
        Integer[] dp_A = new Integer[n];
        Integer[] dp_B = new Integer[n];
        
        return Math.max(
            solve(nums, 0, n-2, dp_A),
            solve(nums, 1, n-1, dp_B)
            );

        // revise with bottom up 
    }
}