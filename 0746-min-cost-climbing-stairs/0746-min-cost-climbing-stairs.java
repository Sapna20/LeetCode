class Solution {

    private int solve(int[] cost, int n, Integer[] dp) {
        if(n == 1 || n == 0) {
            return cost[n];
        }
        if(dp[n] != null) {
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(solve(cost, n-1, dp), solve(cost, n-2, dp));

        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n];

        return Math.min(
            solve(cost, n-1, dp), 
            solve(cost, n-2, dp)
            );

        // need to write bottom up during revision
    }
}