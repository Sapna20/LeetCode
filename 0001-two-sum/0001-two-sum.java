class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            map.put(nums[i], i);
        }

        int[] ans = new int[2];

        for(int i=0; i<n; i++) {
            int x = target - nums[i];
            if(map.containsKey(x) && map.get(x) != i) {
                ans[0] = i;
                ans[1] = map.get(x);
                return ans;
            }
        }

        return ans;
    }
}