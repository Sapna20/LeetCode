class Solution {

    private int solve(int[] nums, int S, int idx, Integer[][] dp) {
        
        if(idx == nums.length) {
            return S == 0 ? 1 : 0;
        }

        if(dp[idx][S] != null) {
            return dp[idx][S];
        }

        if(S - nums[idx] >= 0) {
            dp[idx][S] = solve(nums, S-nums[idx], idx+1, dp) + solve(nums, S, idx+1, dp);
        } else {
            dp[idx][S] = solve(nums, S, idx+1, dp);
        }

        return dp[idx][S];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        } 

        if((sum+target) % 2 != 0) {
            return 0;
        }

        int S = (sum + target)/2;
        if(S < 0) {
            return 0;
        }
        int n = nums.length;
        Integer[][] dp = new Integer[n][S+1];

        return solve(nums, S, 0, dp);
    }
}