class Solution {

    List<String> ans = new ArrayList<>();

    private void solve(int remOpen, int remClose, String curr) {
        if(remOpen == 0 && remClose == 0) {
            ans.add(curr);
            return;
        } 

        if(remOpen == remClose) {
            solve(remOpen - 1, remClose, curr + '(');
        } else if(remOpen < remClose) {
            solve(remOpen, remClose - 1, curr + ')');
            if(remOpen != 0) {
                solve(remOpen - 1, remClose, curr + '(');
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(n, n, "");
        return ans;
    }
}