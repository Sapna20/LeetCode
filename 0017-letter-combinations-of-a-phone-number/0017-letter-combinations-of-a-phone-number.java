class Solution {

    private List<String> solve(String digits, HashMap<Character, String> map, int idx, ArrayList<String> ans, String currStr) {
        if (idx == digits.length()) {
            ans.add(currStr);
            return ans;
        }

        String valStr = map.get(digits.charAt(idx));
        for(int i=0; i<valStr.length(); i++) {
            solve(digits, map, idx+1, ans, currStr + valStr.charAt(i));
        }

        return ans;
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return solve(digits, map, 0, new ArrayList<String>(), "");
    }
}