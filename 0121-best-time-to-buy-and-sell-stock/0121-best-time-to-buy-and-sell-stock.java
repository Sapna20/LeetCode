class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices) {
            profit = Math.max(profit, price - buyPrice);
            buyPrice = Math.min(price, buyPrice);
        }

        return profit;
    }
}