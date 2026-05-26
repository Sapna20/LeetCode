class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lc = new boolean[26];
        boolean[] uc = new boolean[26];

        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                lc[word.charAt(i) - 'a'] = true;
            } else if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                uc[word.charAt(i) - 'A'] = true;
            }
        }

        int count = 0;

        for(int i=0; i<26; i++) {
            if(lc[i] && uc[i]) {
                count++;
            } 
        }

        return count;
    }
}