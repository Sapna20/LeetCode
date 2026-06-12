class Solution {

    private int solve(int[] prices, int idx, int lastBuyIdx, Integer[][] dp) {
        if(idx >= prices.length) {
            if(lastBuyIdx == -1) {
                return 0;
            }
            return -1 * prices[lastBuyIdx];
        }

        if(dp[idx][lastBuyIdx+1] != null) {
            return dp[idx][lastBuyIdx+1];
        }

        if(lastBuyIdx == -1) {
            dp[idx][lastBuyIdx+1] = Math.max(
                solve(prices, idx+1, idx, dp),
                solve(prices, idx+1, lastBuyIdx, dp)
            );
        } else {
            dp[idx][lastBuyIdx+1] =  Math.max(
                prices[idx] - prices[lastBuyIdx] + solve(prices, idx+2, -1, dp),
                solve(prices, idx+1, lastBuyIdx, dp)
            );
        }
        
        return dp[idx][lastBuyIdx+1];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][n+1];

        return solve(prices, 0, -1, dp);
    }
}