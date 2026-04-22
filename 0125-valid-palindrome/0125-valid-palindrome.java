class Solution {

    private boolean isAlphaNumeric(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c>= '0');
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;

        String ls = s.toLowerCase();

        while(i<=j) {
            if(i<n && !isAlphaNumeric(ls.charAt(i))) {
                i++; continue;
            }
            if(j>=0 && !isAlphaNumeric(ls.charAt(j))) {
                j--; continue;
            }

            if(ls.charAt(i) != ls.charAt(j))
                return false;

            i++; j--;
        }

        return true;
    }
}