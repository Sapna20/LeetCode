class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for(int x : nums) {
            set.add(x);
        }

        for(int x : set) {
            if(set.contains(x+1)) {
                continue;
            }
            int curr = 1;
            while(set.contains(x-1)) {
                curr++;
                x--;
            }
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}