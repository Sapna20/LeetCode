class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double ans = 0;
        double currSum = 0;
        
        for(int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        
        ans = currSum / k;
        
        for(int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            ans = Math.max(ans, currSum / k);
        }
        
        return ans;
    }
}