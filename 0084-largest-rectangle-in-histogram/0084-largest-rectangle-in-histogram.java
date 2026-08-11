class Solution {

    private int[] nextSmallerElement(int[] heights, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            };
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return ans;

    }

    private int[] previousSmallerElement(int[] heights, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            };
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nseArr = nextSmallerElement(heights, n);
        int[] pseArr = previousSmallerElement(heights, n);
        int max_so_far = 0;

        for(int i=0; i<n; i++) {
            int width = nseArr[i] - pseArr[i] - 1;
            max_so_far = Math.max(
                max_so_far,
                heights[i] * width
            );
        }
        return max_so_far;
    }
}