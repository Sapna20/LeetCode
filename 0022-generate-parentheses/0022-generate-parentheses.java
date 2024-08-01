class Solution {

    private List<String> generate(String str, List<String> ls, int open, int close) {
        if(open == 0 && close == 0) 
        {
            ls.add(str);
            return ls;
        }

        if(open == close) {
            ls = generate(str + '(', ls, open-1, close);
        } else if (open == 0) {
            ls = generate(str + ')', ls, open, close-1);
        } else {
            ls = generate(str + '(', ls, open-1, close);
            ls = generate(str + ')', ls, open, close-1);
        }

        return ls;
    }

    public List<String> generateParenthesis(int n) {
        
        String str = "";
        List<String> ls = new ArrayList<String> ();

        return generate(str, ls, n, n);
    }
}