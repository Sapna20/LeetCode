class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for(int i=start; i<nums.length; i++) {
            if(nums[i] == target) {
                minDistance = Math.min(minDistance, i-start);
            }
        }

        for(int i=start-1; i>=0; i--){
            if(nums[i] == target) {
                minDistance = Math.min(minDistance, start-i);
            }
        }
        return minDistance;
    }
}