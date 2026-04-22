class Solution {

    private boolean isOpen(Character c) {
        return c == '[' || c == '(' || c == '{';
    }

    private boolean isClose(Character c) {
        return c == ']' || c == ')' || c == '}';
    }

    private boolean isValidPair(Character open, Character close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
        
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(isOpen(c)) {
                st.push(c);
                continue;
            } 

            if(!st.isEmpty()) {
                Character z = st.pop();
                if(!isValidPair(z, c))
                    return false;
            } else {
                return false;
            }
        
        }
        return st.isEmpty();
    }
}