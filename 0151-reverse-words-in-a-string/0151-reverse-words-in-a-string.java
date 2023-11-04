class Solution {
    public String reverseWords(String s) {

        String ans = "";

        for(int i=0; i<s.length(); i++) {
            String word = "";
            while(i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i);
                i++;
            }
            if(!word.equals("")) {
                if(ans.equals("")) {
                    ans = word + ans;
                } else {
                    ans = word + " " + ans;
                }
            }
        }

        return ans;
    }
}