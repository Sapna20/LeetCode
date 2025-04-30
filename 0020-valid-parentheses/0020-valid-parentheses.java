class Solution {

    public boolean isValidPair(char open, char close) {
        if((open == '{' && close != '}')
            || (open == '(' && close != ')')
            || (open == '[' && close != ']') ) {
                return false;
            }
        return true;
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('{', '(', '['));
        List<Character> closeBrackets = new ArrayList<>(Arrays.asList('}', ')', ']'));

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(openBrackets.contains(c)) {
                st.push(c);
            } else if(closeBrackets.contains(c) && !st.isEmpty()) {
                char tc = st.peek();
                if(!isValidPair(tc, c))
                    return false;
                st.pop();
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }
}