class Solution {
    public int removeDuplicates(int[] nums) {
        int res=1;

        // two pointer approach
        // res for updating of non duplicate part of array
        // i for finding unique elements
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[res] = nums[i];
                res++;
            }
        }

        return res;
    }
}