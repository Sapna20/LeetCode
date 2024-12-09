class StockSpanner {

    private Stack<Integer> st = new Stack<Integer>();
    private List<Integer> ls = new ArrayList<Integer>();
    private int index = 0;

    public StockSpanner() {
    }
    
    public int next(int price) {
        int i=1;
        while(!st.empty() && ls.get(st.peek()) <= price) {
            st.pop();
        }
        
        int greaterToTheLeft = st.empty() ? -1 : st.peek();
        
        st.push(index);
        ls.add(price);
        index++;

        return index - greaterToTheLeft - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */