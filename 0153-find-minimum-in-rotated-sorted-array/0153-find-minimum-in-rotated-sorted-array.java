class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;

        while(start <= end) {
            int mid = (end - start)/2 + start;

            if(nums[mid] <= nums[ (mid+1) % n] && nums[mid] <= nums[mid == 0 ? (mid-1 + n) : mid-1]) {
                return nums[mid];
            } else if(nums[mid] > nums[n-1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}