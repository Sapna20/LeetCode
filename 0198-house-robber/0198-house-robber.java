class Solution {

    // Recursive
    // private int solve(int[] nums, int index) {
    //     if(index < 0) {
    //         return 0;
    //     }

    //     return Math.max( nums[index] + solve(nums, index-2), solve(nums, index-1));
    // }

    public int rob(int[] nums) {
        // return solve(nums, nums.length-1);

        // iterative + memo
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2; i<n+1; i++) {
            dp[i] = Math.max( nums[i-1] + dp[i-2], dp[i-1]);
        }

        return dp[n];
    }
}