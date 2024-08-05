class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] rSi = new int[n];
        int[] lSi = new int[n];

        Stack<Integer> st = new Stack<Integer>();

        //find next smaller integer index
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.empty()) {
                rSi[i] = n+1;
            } else {
                rSi[i] = st.peek()+1;
            }
            st.push(i);
        }

        while(!st.empty())
            st.pop();

        //find prev smaller integer index
        for(int i=0; i<n; i++) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.empty()) {
                lSi[i] = 0;
            } else {
                lSi[i] = st.peek()+1;
            }
            st.push(i);   
        } 

        int currMax = 0, ans = 0;

        for(int i=0; i<n; i++) {
            ans = Math.max(ans, (rSi[i] - lSi[i]-1)*heights[i]);
        }

        return ans;
    }
}