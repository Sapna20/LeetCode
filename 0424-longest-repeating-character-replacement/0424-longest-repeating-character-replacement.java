class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i=0, j=0, ans=0;

        int[] freq = new int[26];

        while(j<n) {
            char chRight = s.charAt(j);
            freq[chRight - 'A']++;
            int maxf = 0;
            for(int f : freq) {
                maxf = Math.max(f, maxf);
            }

            if(j-i+1 - maxf <= k) {
                ans = Math.max(ans, j-i+1);
            } else {
                char chLeft = s.charAt(i);
                freq[chLeft - 'A']--;
                i++;
            }

            j++;
        }

        return ans;
    }
}