class Pair {
    int element;
    int minElement;

    Pair(int element, int minElement) {
        this.element = element;
        this.minElement = minElement;
    }

    public int getElement() {
        return element;
    }

    public int getMinElement() {
        return minElement;
    }
}

class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<Pair>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()) {
            stack.push(new Pair(value, value));
        } else {
            stack.push(
                new Pair(
                    value, 
                    value < stack.peek().getMinElement() 
                        ? value 
                        : stack.peek().getMinElement() 
                )
            );
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().getElement();
    }
    
    public int getMin() {
        return stack.peek().getMinElement();
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