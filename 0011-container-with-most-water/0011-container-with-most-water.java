class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int L=0, R=n-1;
        int max_so_far=0;

        while(L<R) {
            int curr_area = (R-L)*Math.min(height[L], height[R]);
            max_so_far = Math.max(curr_area, max_so_far);
            if(height[L] < height[R])
                L++;
            else
                R--;
        }

        return max_so_far;
    }
}