class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(nums[(mid-1+n)%n] >= nums[mid]) {
                return nums[mid];
            }
            else if(nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}