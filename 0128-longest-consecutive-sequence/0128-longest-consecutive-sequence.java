class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for(int num: nums) {
            if(set.contains(num-1) && !set.contains(num+1)) {
                num = num-1;
                int curr = 1;
                while(set.contains(num)) {
                    curr++;
                    num--;
                }
                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }
}