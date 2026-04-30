class Solution {

    private int resolve(String op, int a, int b) {
        if(op.equals("+")) {
            return b+a;
        }
        if(op.equals("-")) {
            return b-a;
        }
        if(op.equals("*")) {
            return b*a;
        }
        if(op.equals("/")) {
            return b/a;
        }

        return 1;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        List<String> operator = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));

        for(String str : tokens) {
            if(operator.contains(str)) {
                int a = st.pop();
                int b = st.pop();
                st.push(resolve(str, a, b));
            } else {
                st.push(Integer.valueOf(str));
            }
        }

        return st.pop();
    }
}