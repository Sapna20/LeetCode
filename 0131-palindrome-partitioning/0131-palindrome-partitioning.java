class Solution {

    private List<List<String>> res = new ArrayList<List<String>>();

    private void solve(String s, int start, List<String> curr_ls) { 
        if(start == s.length()) {
            res.add(new ArrayList<String>(curr_ls));
            return;
        }

        for(int end = start+1; end <= s.length(); end++) {
            String subStr = s.substring(start, end);
            if(isPalindrome(subStr)) {
                curr_ls.add(subStr);
                solve(s, end, curr_ls);
                curr_ls.remove(curr_ls.size()-1);
            }
        }

        return;
    }

    private boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        solve(s, 0, new ArrayList<String>());
        return res;
    }
}