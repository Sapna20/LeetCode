class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;

        if(n == 1) {
            return 0;
        }

        while(start<=end) {
            int mid = (end-start)/2 + start;
            if(mid > 0  && mid < n-1) {
                if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
                    return mid;
                } else if(nums[mid-1] > nums[mid]) {
                    end = mid-1;
                } else if(nums[mid+1] > nums[mid]) {
                    start = mid+1;
                }
            } else {
                if(mid == 0){
                    if(nums[mid] > nums[mid+1])
                        return mid;
                    else 
                        return mid+1;
                } else if (mid == n-1) {
                    if(nums[mid] > nums[mid-1])
                        return mid;
                    else 
                        return mid-1;
                }
            }
        }

        return -1;
    }
}