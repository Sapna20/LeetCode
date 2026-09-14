class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int actual_sum = 0;

        for(int x : nums) {
            actual_sum += x;
        }

        return sum - actual_sum;
    }
}