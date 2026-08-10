class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while(left < right) {
            int smallBar = height[left] < height[right] 
                            ? height[left] 
                            : height[right];
            maxWater = Math.max(maxWater,
                            smallBar * (right - left)
                        );
            if(smallBar == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}