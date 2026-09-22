class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key) && map.get(key) != i) {
                return new int[]{i, map.get(key)};
            }
        }

        return new int[]{};
    }
}