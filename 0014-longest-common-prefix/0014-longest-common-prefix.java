class Solution {
    public String longestCommonPrefix(String[] strs) {
        String curr = "";
        String ans = "";

        for(int i=0; i<strs[0].length(); i++) {
            curr = curr + strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                try {
                    if(!strs[j].substring(0, i+1).equals(curr)) {
                        return ans;
                    }
                } catch (Exception e) {
                    return ans;
                }

            }
            ans = curr;
        }

        return ans;
    }
}