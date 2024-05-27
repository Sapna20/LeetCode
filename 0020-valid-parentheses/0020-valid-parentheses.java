class Solution {
    public boolean isValid(String s) {
        List<Character> openBrackets = new ArrayList<Character>();
        List<Character> closeBrackets = new ArrayList<Character>();
        Stack<Character> st = new Stack<Character>();

        openBrackets.add('{');
        openBrackets.add('[');
        openBrackets.add('(');

        closeBrackets.add('}');
        closeBrackets.add(']');
        closeBrackets.add(')');

        int i=0, n=s.length();

        while(i<n) {
            Character c = s.charAt(i);
            if(openBrackets.contains(c)) {
                st.push(c);
            }
            else if (closeBrackets.contains(c) && !st.isEmpty()) {
                Character temp = st.peek();
                if((c == ')' && temp == '(') || (c == '}' && temp == '{') || (c == ']' && temp == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            } 
            else {
                return false;
            }
            i++;
        }

        return st.isEmpty();
    }
}