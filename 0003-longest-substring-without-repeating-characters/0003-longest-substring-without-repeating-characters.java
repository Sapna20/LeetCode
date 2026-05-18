class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i=0, j=0, n=s.length();

        while(j < n) {
            char c = s.charAt(j);
            if(set.contains(c)) {
                while(s.charAt(i) != c) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(c);
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }

        return ans;
    }
}