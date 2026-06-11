class Solution {

    private boolean solve(int[] nums, int sum, int idx, Boolean[][] dp) {
        if(sum == 0) 
            return true;

        if(sum < 0 || idx < 0) 
            return false;

        if(dp[idx][sum] != null) {
            return dp[idx][sum];
        }

        if(sum - nums[idx] >= 0) {
            dp[idx][sum] = solve(nums, sum-nums[idx], idx-1, dp) || solve(nums, sum, idx-1, dp);
            return dp[idx][sum];
        }

        dp[idx][sum] = solve(nums, sum, idx-1, dp);
        return dp[idx][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int x : nums) {
            sum += x;
        }

        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[n][sum+1];
        
        return solve(nums, sum/2, n-1, dp);
    }
}