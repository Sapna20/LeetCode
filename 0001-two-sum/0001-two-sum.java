class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ans = new int[2];

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            int y = target - nums[i];
            if(map.containsKey(y) && map.get(y) != i) {
                ans[0] = i;
                ans[1] = map.get(y);
                return ans;
            }
        }

        return ans;
    }
}