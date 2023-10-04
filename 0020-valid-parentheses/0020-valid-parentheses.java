class Solution {
    public boolean isPair(Character o, Character c) {

        return (o == '(' && c == ')') || (o == '{' && c == '}') || (o == '[' && c == ']');

    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character> ();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' ) {
                if(!st.isEmpty() && isPair(st.peek(), s.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.empty();
        
    }
}