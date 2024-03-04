class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double ans = (double)nums[0]/k;
        double currSum = ans;
        
        for(int i=1; i<nums.length; i++) {
            if(i<k) {
                currSum += (double)nums[i]/k;
            } else {
                currSum += (double)nums[i]/k - (double)nums[i-k]/k;
            }
            ans = Math.max(currSum, ans);
        }
        return ans;
    }
}