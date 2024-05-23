class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
    
        while(i<j) {
            char c_atI = Character.toLowerCase(s.charAt(i));
            char c_atJ = Character.toLowerCase(s.charAt(j));

            if((c_atI < 'a' || c_atI > 'z') && (c_atI < '0' || c_atI > '9')) {
                i++;
                continue;
            }

            if((c_atJ < 'a' || c_atJ > 'z') && (c_atJ < '0' || c_atJ > '9')) {
                j--;
                continue;
            }

            if(c_atI != c_atJ) 
                return false;
            
            i++;
            j--;
        }

        return true;
    }
}