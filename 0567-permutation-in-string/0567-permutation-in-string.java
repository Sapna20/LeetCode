class Solution {
    private boolean isFreqEqual(int[] f1, int[] f2) {
        for(int i=0; i<26; i++) {
            if(f1[i] != f2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if(m > n) 
            return false;
        
        int[] freq = new int[26];
        int[] windowFreq = new int[26];

        for(int i=0; i<m; i++) {
            freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        int j=m, i=0;
        while( j < n) {
            if(isFreqEqual(freq, windowFreq)) {
                return true;
            }
            windowFreq[s2.charAt(j)-'a']++;
            j++;
            windowFreq[s2.charAt(i) - 'a']--;
            i++;
        }

        if(isFreqEqual(freq, windowFreq)) {
            return true;
        }

        return false;

    }
}