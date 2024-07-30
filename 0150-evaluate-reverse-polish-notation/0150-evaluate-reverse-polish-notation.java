class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer> ();
        List<String> ls = new ArrayList<String> ();
        ls.add("+");
        ls.add("-");
        ls.add("*");
        ls.add("/");

        for(int i=0; i<tokens.length; i++) {
            if(!ls.contains(tokens[i])) {
                st.push(Integer.parseInt(tokens[i]));
            } else {
                if(tokens[i].charAt(0) == '+') {
                    int a = 1;
                    int b = 1;
                    if(!st.isEmpty()) {
                        a = st.pop();
                    }
                    if(!st.isEmpty()) {
                        b = st.pop();
                    }
                    st.push(a+b);
                } 
                if(tokens[i].charAt(0) == '-') {
                    int a = 1;
                    int b = 1;
                    if(!st.isEmpty()) {
                        a = st.pop();
                    }
                    if(!st.isEmpty()){
                        b = st.pop();
                    }
                    st.push(b-a);
                }
                if(tokens[i].charAt(0) == '*') {
                    int a = 1;
                    int b = 1;
                    if(!st.isEmpty()) {
                        a = st.pop();
                    }                    
                    if(!st.isEmpty()) {
                        b = st.pop();
                    }
                    st.push(a*b);
                }
                if(tokens[i].charAt(0) == '/') {
                    int a = 1;
                    int b = 1;
                    if(!st.isEmpty()) {
                        a = st.pop();
                    }                    
                    if(!st.isEmpty()) {
                        b = st.pop();
                    }
                    st.push(b/a);
                } 
            }
        }
        int ans = 1;
        if(!st.isEmpty()) {
            ans = st.pop();
        }

        return ans;

    }
}