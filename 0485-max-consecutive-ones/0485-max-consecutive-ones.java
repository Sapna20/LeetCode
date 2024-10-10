class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = nums[0] == 1 ? 1 : 0;
        int max = curr;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 1) {
                curr++;
                max = Math.max(curr, max);
            } else {
                curr = 0;
            }
        }
        return max;
    }
}