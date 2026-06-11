class Solution {

    private int solve(int[] nums, int n, Integer[] dp) {
        if(n < 0) {
            return 0;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        dp[n] = Math.max(
            nums[n] + solve(nums, n-2, dp),
            solve(nums, n-1, dp)
        );

        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];

        return solve(nums, n-1, dp);

        // write bottom up during revision
    }
}