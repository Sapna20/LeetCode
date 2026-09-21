class Solution {

    private boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i=0, j=s.length()-1;

        while(i<=j) {
            if(!isValid(str.charAt(i))) {
                i++;
                continue;
            }

            if(!isValid(str.charAt(j))) {
                j--;
                continue;
            }

            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}