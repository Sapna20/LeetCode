class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0, k = 0;

        while(i<m && j<n) {
            if(k%2 == 0) {
                ans += word1.charAt(i);
                i++;
            } else {
                ans += word2.charAt(j);
                j++;
            }
            k++;
        }

        if(i < m)
            ans += word1.substring(i, m);

        if(j < n) 
            ans += word2.substring(j, n);

        return ans;
    }
}