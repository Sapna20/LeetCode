class Solution {

    private boolean canJumpMemo(int[] nums, int index, Boolean[] dp) {
        if(index == nums.length-1)
            return true;
        if(dp[index] != null) {
            return dp[index];
        }
        boolean ans = false;

        for(int i=1; i<=nums[index]; i++) {
            ans = ans || canJumpMemo(nums, index+i, dp);
            if(ans) 
                return ans;
        }

        dp[index] = ans;

        return ans;
    }

    private boolean canJumpTabular(int[] nums, Boolean[] dp) {
        return true;
    }

    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return canJumpMemo(nums, 0, dp);
    }
}