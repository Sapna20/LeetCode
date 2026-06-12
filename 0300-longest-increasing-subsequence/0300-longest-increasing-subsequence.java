class Solution {

    private int solve(int[] nums, int idx, Integer lastNumIdx, Integer[][] dp) {
        if(idx == nums.length) {
            return 0;
        }

        if( lastNumIdx != null && dp[idx][lastNumIdx] != null) {
            return dp[idx][lastNumIdx];
        }

        int curr_max = 0;
        if(lastNumIdx == null || nums[lastNumIdx] < nums[idx]) {
            curr_max = Math.max(
                1+solve(nums, idx+1, idx, dp),
                solve(nums, idx+1, lastNumIdx, dp) 
                );
            
        } else {
            curr_max = solve(nums, idx+1, lastNumIdx, dp);
        }

        if( lastNumIdx != null) {
            dp[idx][lastNumIdx] = curr_max;
        }

        return curr_max;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return solve(nums, 0, null, dp);
    }
}