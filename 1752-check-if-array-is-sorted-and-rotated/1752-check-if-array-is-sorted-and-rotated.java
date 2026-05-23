class Solution {
    public boolean check(int[] nums) {
        int pivot_count = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if (nums[i] > nums[(i+1) % n]) {
                pivot_count++;
            }
        }


        return pivot_count <= 1;
    }
}