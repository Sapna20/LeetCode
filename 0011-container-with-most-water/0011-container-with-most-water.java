class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length-1;

        //two pointer at leftmost and rightmost end
        while(l<r) {
            int currArea = (r-l)*Math.min(height[l], height[r]);
            if(maxArea < currArea) {
                maxArea = currArea;
            }
            //move pointer that is at lower height because calulating area at same height again will give less area
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        
        return maxArea;
    }
}