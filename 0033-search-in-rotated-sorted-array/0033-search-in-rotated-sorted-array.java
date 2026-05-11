class Solution {

    private int searchStartIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(nums[mid] <= nums[(mid-1+n) % n]) {
                return mid;
            } else if (nums[mid] < nums[start]) {
                end = mid-1;
            } else if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return Integer.MAX_VALUE;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int startIndex = searchStartIndex(nums);
        int n = nums.length;
        
        return target >= nums[startIndex] && target <= nums[n-1] 
                            ? binarySearch(nums, target, startIndex, nums.length-1)
                            : binarySearch(nums, target, 0, startIndex-1);
        
    }
}