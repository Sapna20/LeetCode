class Solution {
    public int maximumDifference(int[] nums) {
        int max_dif = Integer.MIN_VALUE;
        int min_so_far = nums[0];
        int n = nums.length;

        for(int i=1; i<n; i++) {
            if(nums[i] > min_so_far) {
                max_dif = Math.max(max_dif, nums[i]-min_so_far);
            }
            min_so_far = Math.min(min_so_far, nums[i]);
        }

        if(max_dif == Integer.MIN_VALUE) {
            return -1;
        }

        return max_dif;
    }
}