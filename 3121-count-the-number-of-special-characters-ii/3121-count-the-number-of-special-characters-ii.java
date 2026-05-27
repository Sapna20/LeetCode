class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arrLower = new int[26];
        int[] arrUpper = new int[26];

        for(int i=0; i<26; i++) {
            arrLower[i] = -1;
            arrUpper[i] = -1;
        }

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'a' && c <= 'z') {
                arrLower[c-'a'] = i;
            } else if (c >= 'A' && c <= 'Z') {
                if(arrUpper[c-'A'] == -1) {
                    arrUpper[c-'A'] = i;
                }
            }
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if ( arrLower[i] != -1 && arrUpper[i] != -1 && (arrLower[i] < arrUpper[i])) {
                count++;
            }
        }

        return count;
    }
}