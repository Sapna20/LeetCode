class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, j=0, n=s.length();
        int maxLength = 0;

        while(i<n && j<n && i<=j) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                j++;
                maxLength = Math.max(maxLength, j-i);
            } else {
                while(s.charAt(i) != c) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLength;
    }
}