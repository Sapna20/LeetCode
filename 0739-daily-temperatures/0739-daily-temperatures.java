class Pair {
    int data;
    int idx;

    Pair(int data, int idx) {
        this.data = data;
        this.idx = idx;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<Pair>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek().data <= temperatures[i]) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek().idx - i;
            }

            st.push(new Pair(temperatures[i], i));
        }

        return ans;
    }
}