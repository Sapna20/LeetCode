class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = (end - start)/2 + start;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return -1;
    }
}