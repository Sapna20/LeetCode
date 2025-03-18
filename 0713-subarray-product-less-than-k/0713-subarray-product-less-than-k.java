class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)
            return 0;
        int ans = 0, L = 0, R = 0, n = nums.length;
        int prod = 1;
        while(R<n) {
            prod *= nums[R];
            while(prod >= k && L<=R) {
                prod /= nums[L];
                L++;
            }
            
            ans += R-L+1;
            R++;

        }

        return ans;
    }
}