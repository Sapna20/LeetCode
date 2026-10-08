class Solution {
    public int maxProduct(int[] nums) {
        int maxP = Integer.MIN_VALUE, leftMax = 1, rightMax = 1;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                leftMax = 1;
                maxP = Math.max(nums[i], maxP);
            } else {
                leftMax *= nums[i];
                maxP = Math.max(leftMax, maxP);
            }

            if(nums[n-i-1] == 0) {
                rightMax = 1;
                maxP = Math.max(nums[n-i-1], maxP);
            } else {
                rightMax *= nums[n-i-1];
                maxP = Math.max(rightMax, maxP);
            }
        }

        return maxP;
    }
}