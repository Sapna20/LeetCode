class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length, max = 0, curr = 0;

        for(int i=0; i<n; i++) {
            if(nums[i]%2 == 0 && nums[i] <= threshold && curr%2 == 0) {
                curr++;
            } else if(nums[i]%2 != 0 && nums[i] <= threshold && curr%2 != 0 ) {
                curr++;
            } else {
                curr = nums[i]%2 == 0 && nums[i] <= threshold ? 1 : 0;
            }
            res = Math.max(res, curr);
        }

        return res;
    }
}