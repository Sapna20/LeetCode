class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] ans = new int[n];

        pre[0] = 1;
        for(int i=1; i<n; i++) {
            pre[i] = pre[i-1]*nums[i-1];
        }

        suf[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            suf[i] = suf[i+1]*nums[i+1];
        }

        for(int i=0; i<n; i++) {
            ans[i] = suf[i]*pre[i];
        }

        return ans;
    }
}