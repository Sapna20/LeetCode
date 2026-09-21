class Solution {

    private boolean isOpen(Character c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isValid(Character open, Character close) {
        return (open == '(' && close == ')') 
            || (open == '[' && close == ']') 
            || (open == '{' && close == '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isOpen(c)) {
                stack.push(c);
                continue;
            } 
            
            if(stack.isEmpty() || !isValid(stack.peek(), c)) {
                return false;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }
}