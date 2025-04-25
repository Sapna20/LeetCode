class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int currMaj = nums[0];

        for(int x : nums) {
            count += currMaj == x ? 1 : -1;
            if(count == 0) {
                currMaj = x;
                count = 1;
            }
        }
        return currMaj;
    }
}