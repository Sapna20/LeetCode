class Pair {
    int min;
    int val;
    Pair(int min, int val) {
        this.min = min;
        this.val = val;
    }
}

class MinStack {

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()) {
            stack.push(new Pair(value, value));
        } else {
            int min_so_far = stack.peek().min;
            int curr_min = value < min_so_far ? value : min_so_far;
            stack.push(new Pair(curr_min, value));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */