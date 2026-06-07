class Solution {

    private List<String> solve(int open, int close, ArrayList<String> ans, String currStr) {
        if(close == 0) {
            ans.add(currStr);
            return ans;
        }

        if(open == close) {
            solve(open-1, close, ans, currStr + '(');
        } else {
            if(open > 0) {
                solve(open-1, close, ans, currStr + '(');
            }
            solve(open, close-1, ans, currStr + ')');
        }

        return ans;

    }

    public List<String> generateParenthesis(int n) {
        return solve(n, n, new ArrayList<String>(), "");
    }
}