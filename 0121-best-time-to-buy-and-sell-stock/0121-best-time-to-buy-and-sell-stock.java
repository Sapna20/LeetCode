class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = -1;

        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(prices[i] - buy, maxProfit);
            buy = prices[i] < buy ? prices[i] : buy;
        }
        return maxProfit;
    }
}