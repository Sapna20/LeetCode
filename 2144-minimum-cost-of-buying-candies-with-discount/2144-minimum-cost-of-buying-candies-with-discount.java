class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0;
        int pos = 1;
        for(int i=cost.length-1; i>=0; i--) {
            if(pos % 3 == 0) {
                pos++;
                continue;
            }
            minCost += cost[i];
            pos++;
        }

        return minCost;
    }
}