class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currAvg = 0.0;

        for(int i=0; i<k; i++) {
            currAvg += (double)nums[i];
        }
        currAvg = currAvg/k;

        double maxAvg = currAvg;

        int i=0;
        int j=k;
        while(j<nums.length) {
            currAvg = currAvg - (double)nums[i]/k + (double)nums[j]/k;
            maxAvg = Math.max(maxAvg, currAvg);
            j++;
            i++;
        }

        return maxAvg;

    }
}