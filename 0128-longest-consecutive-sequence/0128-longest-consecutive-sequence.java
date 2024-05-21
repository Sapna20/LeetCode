class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for(int x : nums) {
            set.add(x);
        }

        int maxSoFar = 0;
        
        for(int x : nums) {
            if(set.contains(x+1)) {
                continue;
            }
            int currMax = 0;
            while(set.contains(x)) {
                currMax++;
                maxSoFar = Math.max(maxSoFar, currMax);
                x--;
            }
        }

        return maxSoFar;
    }
}