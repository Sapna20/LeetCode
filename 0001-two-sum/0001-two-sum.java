class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<> ();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(target-nums[i])) {
                map.put(target-nums[i], i);
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i]) && i != map.get(nums[i])){
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                return ans;
            }
        }
        return ans;
    }
}