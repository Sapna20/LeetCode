import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int[] ans = new int[] {0, 0};

        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(hm.get(target - nums[i]) != null && hm.get(target - nums[i]) != i && nums[i] + nums[hm.get(target - nums[i])] == target ) {
                ans[0] = i;
                ans[1] = hm.get(target - nums[i]);
            }
        }

        return ans;
    }
}