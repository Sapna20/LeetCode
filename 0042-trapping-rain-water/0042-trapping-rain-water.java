class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lh = new int[n];
        int[] rh = new int[n];

        int maxL = 0;
        for(int i=1; i<n; i++) {
            maxL = Math.max(height[i-1], maxL);
            lh[i] = maxL;
        }

        int maxR = 0;
        for(int i=n-2; i>0; i--) {
            maxR = Math.max(height[i+1], maxR);
            rh[i] = maxR;
        }

        int total = 0;
        for(int i=1; i<n-1; i++) {
            int water = Math.min(lh[i], rh[i]) - height[i];
            total += water > 0 ? water : 0;
        }

        return total;
    }
}