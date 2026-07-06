class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int j=0, n=nums.length;

        while(j < n) {
            curr_sum = curr_sum + nums[j];
            max_sum = Math.max(max_sum, curr_sum);
            if(curr_sum < 0) {
                curr_sum = 0;
            }
            j++;
        } 
        return max_sum;
    }
}