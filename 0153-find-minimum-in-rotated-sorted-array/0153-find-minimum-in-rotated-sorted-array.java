class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int n = nums.length;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(nums[mid] <= nums[(mid+1)%n] && nums[mid] <= nums[mid-1 == -1 ? n-1 : mid-1]) {
                return nums[mid];
            } else if(nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}