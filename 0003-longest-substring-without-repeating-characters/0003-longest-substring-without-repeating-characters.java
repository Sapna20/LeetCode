class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, n=s.length();
        int maxWindow = 0;
        Set<Character> set = new HashSet<Character>();
        

        while(j < n) {
            char c = s.charAt(j);
            
            while(set.contains(c)){
                set.remove(s.charAt(i));
                i++;
            } 
            set.add(c);
            maxWindow = Math.max(maxWindow, j-i+1);
            j++;
        }

        return maxWindow;
    }
}