class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices) {
            profit = Math.max(profit, price - buy);
            buy = Math.min(buy, price);
        }

        return profit;
    }
}