class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        String ans = "";
        int i, j, k;
        for(i=0, j=0, k=0; i<n && j<m; k++) {
            if(k%2 == 0) {
                ans += word1.charAt(i);
                i++;
            } else {
                ans += word2.charAt(j);
                j++;
            }
        }

        if(i==n) {
            ans += word2.substring(j, m);
        }

        if(j==m) {
            ans += word1.substring(i, n);
        }

        return ans;
    }
}