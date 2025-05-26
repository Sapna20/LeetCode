class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        
        int l=0;
        int r=n-1;
        int lmax = height[l];
        int rmax = height[r];
        int total = 0;

        while(l<r) {
            if(lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                total += lmax - height[l]; 
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                total += rmax - height[r];
            }
        }

        return total;
    }
}