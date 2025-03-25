class Solution {

    private boolean canSubJump(int[] nums, int dind, int[] dp) {
        boolean result = false;
        for(int i=dind-1; i>=0; i--) {
            if(dp[i] == 0) {
                return false;
            }
            if(dp[i] == 1) {
                return true;
            }
            if(dind-i <= nums[i]) {
                if(i==0) {
                    return true;
                }
                else {
                    result = result || canSubJump(nums, i, dp);
                    dp[i] = result == false ? 0 : 1;
                } 
            } 
        }

        return result;
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int[] dp = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            dp[i] = -1;
        }

        return canSubJump(nums, nums.length-1, dp);
    }
}