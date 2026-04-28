class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int longestLength = 0;

        for(int x : nums) {
            set.add(x);
        }

        for(int x : set) {
            if(set.contains(x-1))
                continue;
            
            int temp = 1;
            while(set.contains(x+1))
            {
                temp++;
                x++;
            }
            longestLength = Math.max(temp, longestLength);
        }

        return longestLength;
    }
}