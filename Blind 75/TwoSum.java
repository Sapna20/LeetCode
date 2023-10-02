/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
**/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i]) && i != map.get(target-nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                return ans;
            }
        }

        return ans;
    }
}
