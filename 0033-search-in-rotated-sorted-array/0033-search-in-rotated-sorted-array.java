class Solution {

    private int findPivotIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(nums[mid] <= nums[(mid+1)%n] && nums[mid] <= nums[(mid-1+n)%n]) {
                return mid;
            } else if(nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivotIdx = findPivotIndex(nums);
        System.out.println(pivotIdx);
     
        if(pivotIdx == -1) {
            return -1;
        } 

        int n = nums.length;

        int firstSearch = binarySearch(nums, 0, (pivotIdx-1+n)%n, target);
        int secondSearch = binarySearch(nums, pivotIdx, n-1, target);

        return firstSearch != -1 ? firstSearch : secondSearch;
    }
}