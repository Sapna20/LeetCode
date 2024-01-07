class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i=0;
        StringBuilder ans = new StringBuilder();
        
        while(i<n || i<m) {
            if(i<n) {
                ans.append(word1.charAt(i));
            }

            if(i<m) {
                ans.append(word2.charAt(i));
            }
            i++;
        }

        return ans.toString();
    }
}