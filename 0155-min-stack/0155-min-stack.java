
class Pair {
    int data;
    int minData;

    Pair(int data, int minData) {
        this.data = data;
        this.minData = minData;
    }
}

class MinStack {

    Stack<Pair> st;

    public MinStack() {
        this.st = new Stack<Pair>();
    }
    
    public void push(int val) {
        int min = st.isEmpty() ? val : getMin();
        if(val < min) {
            st.push(new Pair(val, val));
        } else {
            st.push(new Pair(val, min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().data;
    }
    
    public int getMin() {
        return st.peek().minData;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */