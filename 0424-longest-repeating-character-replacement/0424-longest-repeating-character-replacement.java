class Solution {

    private int findMaxFrequency(Map<Character, Integer> fmap) {
        int fmax = 0;
        for(int x : fmap.values()) {
            fmax = Math.max(x, fmax);
        }
        return fmax;
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> fmap = new HashMap<>();
        int n = s.length();
        int i=0, j=0, ans = 0;

        while(j < n) { 
            char c = s.charAt(j);
            fmap.put(c, fmap.getOrDefault(c, 0)+1);
            
            int fmax = findMaxFrequency(fmap);
            while(k < j-i+1 - fmax) {
                fmap.put(s.charAt(i), fmap.get(s.charAt(i)) - 1);
                i++;
                fmax = findMaxFrequency(fmap);
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}