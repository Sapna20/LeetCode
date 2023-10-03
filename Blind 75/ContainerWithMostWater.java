/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.*/

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
