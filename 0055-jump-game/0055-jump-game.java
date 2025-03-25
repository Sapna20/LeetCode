class Solution {

    private boolean canReachLast(int[] nums, int index) {
        if(index == nums.length-1)
            return true;
        
        boolean ans = false;

        for(int i=1; i<=nums[index]; i++) {
            ans = ans || canReachLast(nums, index+i);
        }

        return ans;
    }

    public boolean canJump(int[] nums) {
        return canReachLast(nums, 0);
    }
}