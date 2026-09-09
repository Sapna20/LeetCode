class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int lastIndex = n-1;
        int total = 0;
         
        while(lastIndex > 0) {
            for(int i=0; i<lastIndex; i++) {
                if(i+nums[i] >= lastIndex) {
                    lastIndex = i;
                    total++;
                    break;
                }
            }
        }

        return total;
    }
}