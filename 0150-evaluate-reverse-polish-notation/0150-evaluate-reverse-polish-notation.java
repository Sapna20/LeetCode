class Solution {

    private boolean isOperator(String str) {
        return str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/");
    }

    private int calculate(int num1, int num2, String str) {
        if(str.equals("+")) {
            return num1+num2;
        } else if(str.equals("*")) {
            return num1*num2;
        } else if(str.equals("-")) {
            return num1-num2;
        } else {
            return num1/num2;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for(String str : tokens) {
            if(isOperator(str)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int ans = calculate(num1, num2, str);
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }
}