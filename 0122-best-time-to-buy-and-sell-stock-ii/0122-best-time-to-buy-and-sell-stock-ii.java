class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            buy = Math.min(buy, prices[i]);

            if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }

        return profit;
    }
}