class Solution {
    public int maxArea(int[] height) {
        int L = 0, R = height.length-1, ans = 0;

        while(L<R) {
            ans = Math.max(ans, Math.min(height[L], height[R])*(R-L));
            if(height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return ans;
    }
}