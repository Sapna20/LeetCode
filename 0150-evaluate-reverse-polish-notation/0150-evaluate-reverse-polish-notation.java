class Solution {

    private int calculateRPN(int a, int b, String c) {
        switch (c) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return -1;
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("*") || op.equals("-") || op.equals("/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++) {
            String c = tokens[i];
            if(!isOperator(c)) {
                stack.push(Integer.parseInt(c));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int res = calculateRPN(a, b, c);
                stack.push(res);
            }
        }

        return stack.pop();
    }
}