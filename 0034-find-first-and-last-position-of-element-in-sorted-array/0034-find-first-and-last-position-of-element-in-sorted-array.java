class Solution {

    private int firstOccurance(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start<=end) {
            int mid = (end - start)/2 + start;
            if((nums[mid] == target && mid == 0) 
            || (nums[mid] == target && nums[mid-1] != target)) {
                return mid;
            } else if (nums[mid] >= target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                start = mid+1;
            }
        }

        return -1;
    }

    private int lastOccurance(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start<=end) {
            int mid = (end - start)/2 + start;
            if((nums[mid] == target && mid == nums.length-1) 
            || (nums[mid] == target && nums[mid+1] != target)) {
                return mid;
            }else if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] <= target) {
                start = mid+1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccurance(nums, target);
        ans[1] = lastOccurance(nums, target);

        return ans;
    }
}