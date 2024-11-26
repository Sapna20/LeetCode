class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*' && !st.empty()) 
                st.pop();
            else
                st.push(s.charAt(i));
        }
        String ans = "";
        while(!st.empty()) {
            ans = st.peek()+ans;
            st.pop();
        }

        return ans;
    }
}