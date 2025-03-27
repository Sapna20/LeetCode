class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int curr_so_far = 0;

        for(int i=0; i<nums.length; i++) {
            curr_so_far += nums[i];
            max_so_far = Math.max(curr_so_far, max_so_far);
            
            if(curr_so_far < 0) {
                curr_so_far = 0;
            }
        }

        return max_so_far;

    }
}