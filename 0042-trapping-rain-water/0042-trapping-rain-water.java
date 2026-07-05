class Solution {
    public int trap(int[] height) {
        int i=0, j = height.length-1;
        int total = 0, lmax = height[i], rmax = height[j];

        while(i < j) {
            if(lmax <= rmax) {
                i++;
                lmax = Math.max(lmax, height[i]);
                total += lmax - height[i];
            } else {
                j--;
                rmax = Math.max(rmax, height[j]);
                total += rmax - height[j];
            }
        }

        return total;
    }
}