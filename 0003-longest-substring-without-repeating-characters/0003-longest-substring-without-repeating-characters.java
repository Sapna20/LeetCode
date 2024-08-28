class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character> ();
        int i=0; 
        int j=0;
        int n = s.length();
        int max = 0;

        while(j<n) {
            if(set.contains(s.charAt(j))) {
                while(s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                if(max < set.size()) {
                    max = set.size();
                }
            }
        }

        return max;
    }
}