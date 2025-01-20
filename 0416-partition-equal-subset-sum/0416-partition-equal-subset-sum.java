class Solution {

    private boolean solve(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                if(i==0)
                    dp[i][j] = false;

                if(j==0)
                    dp[i][j] = true;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=target; j++) {
                if(j-nums[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }

        if(sum % 2 != 0)
            return false; 

        return solve(nums, sum/2);

    }
}