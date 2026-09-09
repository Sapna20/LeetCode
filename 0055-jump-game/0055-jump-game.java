class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIndex = n-1;

        for(int i=n-1; i>=0; i--) {
            if(nums[i] + i >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;
    }
}