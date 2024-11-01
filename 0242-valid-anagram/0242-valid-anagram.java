class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();

        if(m != n) {
            return false;
        }

        char[] carr = new char[26];

        for(int i=0; i<m; i++) {
            carr[s.charAt(i)-'a']++;
            carr[t.charAt(i)-'a']--;
        }

        for(int i : carr) {
            if(i!=0) 
                return false;
        }
        
        return true;
    }
}