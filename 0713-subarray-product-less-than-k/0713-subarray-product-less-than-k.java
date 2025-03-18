class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            int curr=1;
            for(int j=i; j<nums.length; j++) {
                curr *= nums[j];
                if(curr < k)
                    ans++;
                else
                    break;
            }
        }

        return ans;
    }
}