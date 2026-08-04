class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int x : nums) {
            set.add(x);
        }

        int max_count = 0;

        for(int x : set) {
            if(!set.contains(x+1)) {
                int dec_seq = x;
                int curr_max = 0;
                while(set.contains(dec_seq)) {
                    curr_max++;
                    max_count = Math.max(max_count, curr_max);
                    dec_seq--;
                }
            }
        }

        return max_count;
    }
}