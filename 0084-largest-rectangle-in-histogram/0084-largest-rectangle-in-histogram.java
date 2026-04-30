class Solution {

    private int[] nextSmallerElementIdx(int[] h, int defaultIdx) {
        Stack<Integer> st = new Stack<Integer>();
        int[] nse = new int[h.length]; 
        for(int i=h.length-1; i>=0; i--) {
            while(!st.empty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            nse[i] = st.empty() ? defaultIdx : st.peek();
            
            st.push(i);
        }

        return nse;
    }

    private int[] prevSmallerElementIdx(int[] h, int defaultIdx) {
        Stack<Integer> st = new Stack<Integer>();
        int[] pse = new int[h.length]; 
        for(int i=0; i<h.length; i++) {
            while(!st.empty() && h[st.peek()] >= h[i]) {
                st.pop();
            }

            pse[i] = st.empty() ? defaultIdx : st.peek();
            
            st.push(i);
        }

        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        
        nsr = nextSmallerElementIdx(heights, n);
        nsl = prevSmallerElementIdx(heights, -1);

        int maxArea=0;

        for(int i=0; i<n; i++) {
            maxArea = Math.max(maxArea, 
                        (nsr[i] - nsl[i] - 1) * heights[i]
                    );
        }

        return maxArea;
    }
}