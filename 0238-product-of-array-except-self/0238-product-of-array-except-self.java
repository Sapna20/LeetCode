class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suf = new int[n];
        int[] ans = new int[n];

        pref[0] = 1;
        suf[n-1] = 1;

        for(int i=1; i<n; i++) {
            pref[i] = nums[i-1]*pref[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            suf[i] = nums[i+1]*suf[i+1];
        }

        for(int i=0; i<n; i++) {
            ans[i] = suf[i]*pref[i];
        }

        return ans;

    }
}