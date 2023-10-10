class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            currMax += nums[i];
            max = Math.max(currMax, max);
            if(currMax < 0) {
                currMax = 0;
            }
        }
        
        return max;
    }
}