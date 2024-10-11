class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int curr_so_far = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] + curr_so_far < 0) {
                curr_so_far = 0;
                max_so_far = Math.max(max_so_far, nums[i]);
            } else {
                curr_so_far += nums[i];
                max_so_far = Math.max(max_so_far, curr_so_far);
            }
        }

        return max_so_far;

    }
}