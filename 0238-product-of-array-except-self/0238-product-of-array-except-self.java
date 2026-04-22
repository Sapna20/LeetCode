class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] larr = new int[n];
        int[] rarr = new int[n];
        int[] ans = new int[n];
        larr[0] = 1;
        rarr[n-1] = 1;

        for(int i=1; i<n; i++) {
            larr[i] = larr[i-1]*nums[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            rarr[i] = rarr[i+1]*nums[i+1];
        }

        for(int i=0; i<n; i++) {
            ans[i] = rarr[i]*larr[i];
        }

        return ans;
    }
}