class Solution {
    public int maxProfit(int[] prices) {
        int min_so_far = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int curr_price : prices) {
            min_so_far = Math.min(min_so_far, curr_price);
            max_profit = Math.max(max_profit, curr_price - min_so_far);
        }

        return max_profit;
    }
}