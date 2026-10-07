class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int rmax = 0, lmax = 0;
        int water = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                lmax = Math.max(lmax, height[left]);
                water += Math.max(0, lmax - height[left]); 
                left++;
            } else {
                rmax = Math.max(rmax, height[right]);
                water += Math.max(0, rmax - height[right]); 
                right--;
            }
        }

        return water;
    }
}