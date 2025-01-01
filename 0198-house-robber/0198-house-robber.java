class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int[] dp = new int[n+2]; 
        for(int i=n-1; i>=0; i--) {
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }

        return dp[0];
    }
}