class Solution {

    boolean isValidChar(char ch) {
        return (ch >= 'a' && ch <= 'z') 
                || (ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        s = s.toLowerCase();
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(!isValidChar(leftChar)) {
                left++;
                continue;
            }

            if(!isValidChar(rightChar)) {
                right--;
                continue;
            }

            if(leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}