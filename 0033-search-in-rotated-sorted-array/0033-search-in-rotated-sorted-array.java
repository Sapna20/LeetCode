class Solution {

    private int getPivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int n = nums.length;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= nums[(mid+1) % n] && nums[mid] <= nums[(mid-1+n) % n]) {
                return mid;
            } else if(nums[mid] > nums[n-1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int p = getPivotIndex(nums);

        if(p == -1) {
            return -1;
        }

        int optionA = binarySearch(Arrays.copyOfRange(nums, 0, p), target);
        int optionB = binarySearch(Arrays.copyOfRange(nums, p, nums.length), target);

        return optionA != -1 ? optionA : optionB != -1 ? optionB + p : -1;

    }
}