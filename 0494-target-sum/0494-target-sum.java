class Solution {

    private int solve(int[] nums, int S, int idx) {
        
        if(idx == nums.length) {
            return S == 0 ? 1 : 0;
        }

        if(S - nums[idx] >= 0) {
            return solve(nums, S-nums[idx], idx+1) + solve(nums, S, idx+1);
        }

        return solve(nums, S, idx+1);
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

        return solve(nums, S, 0);
    }
}