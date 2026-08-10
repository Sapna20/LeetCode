class Solution {
    public int trap(int[] height) {
        int leftmaxH = 0;
        int rightmaxH = 0;
        int lptr = 0;
        int rptr = height.length - 1;
        int maxWater = 0;

        while(lptr < rptr) {
            if(height[lptr] < height[rptr]) {
                leftmaxH = Math.max(leftmaxH, height[lptr]);
                maxWater += leftmaxH - height[lptr];
                lptr++;
            } else {
                rightmaxH = Math.max(rightmaxH, height[rptr]);
                maxWater += rightmaxH - height[rptr];
                rptr--;
            }
        }

        return maxWater;
    }
}