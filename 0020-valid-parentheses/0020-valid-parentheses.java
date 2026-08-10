class Solution {

    boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    boolean isClose(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    boolean isOpenPairPresent(char close, char stTop) {
        return ( close == ')' && stTop == '(' )
            || ( close == '}' && stTop == '{' )
            || ( close == ']' && stTop == '[' );
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(isOpen(c)) {
                st.push(c);
            } else if(isClose(c)) {
                if(st.isEmpty() || !isOpenPairPresent(c, st.peek())) {
                    return false;
                }

                st.pop();
            }
        }

        return st.isEmpty();
    }
}