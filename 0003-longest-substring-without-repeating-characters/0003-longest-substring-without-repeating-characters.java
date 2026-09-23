class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        int ans = 0;

        while(j < s.length()) {
            char c = s.charAt(j);
            if(set.contains(c)) {
                while(set.contains(c)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            } else {
                set.add(c);
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }

        return ans;

    }
}