class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int ans = 0;

        L[0] = 0;
        R[n-1] = 0;

        for(int i=1; i<n; i++) {
            L[i] = Math.max(height[i-1], L[i-1]);
        }

        for(int j=n-2; j>=0; j--) {
            R[j] = Math.max(height[j+1], R[j+1]);
        }

        for(int k=0; k<n; k++) {
            ans += Math.max(0, Math.min(L[k], R[k]) - height[k]);
        }

        return ans;

    }
}