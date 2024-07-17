class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinStack() {
        this.stack = new Stack<Integer> ();
        this.minStack = new Stack<Integer> ();
    }
    
    public void push(int val) {

        stack.push(val);

        if(minStack.empty() ||  minStack.peek() > val)
            minStack.push(val);
        else
            minStack.push(minStack.peek());
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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