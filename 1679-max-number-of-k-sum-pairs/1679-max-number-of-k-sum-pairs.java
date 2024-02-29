class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int L = 0, R = nums.length-1, ans=0;

        while(L<R) {
            if(nums[L] + nums[R] == k) {
                L++;
                R--;
                ans++;
            } else if(nums[L] + nums[R] < k) {
                L++;
            } else {
                R--;
            }
        }

        return ans;
    }
}