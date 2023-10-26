class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        String word3 = "";
        int im = 0;
        int in = 0;

        for(int i=0; i<m+n; i++) {
            if(i%2 == 0) {
                if(im < m) {
                    word3 += word1.charAt(im);
                    im++;
                } else {
                    word3 += word2.charAt(in);
                    in++;
                }

            } else if (i%2 != 0) {
                if(in < n) {
                    word3 += word2.charAt(in);
                    in++;
                } else {
                    word3 += word1.charAt(im);
                    im++;
                }
            }
        }

        return word3;
    }
}