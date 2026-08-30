class Solution {

    private int robBottomUp(int[] nums, int start, int end) { // 1, 2
        if(start == end) {
            return nums[start];
        } 
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i=2; i<=end-start; i++) {
            dp[i] = Math.max(
                            nums[i+start] + dp[i-2],
                            dp[i-1]
                        );
        }

        return dp[end-start];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(
            robBottomUp(nums, 0, n-2),
            robBottomUp(nums, 1, n-1)
        );
    }
}