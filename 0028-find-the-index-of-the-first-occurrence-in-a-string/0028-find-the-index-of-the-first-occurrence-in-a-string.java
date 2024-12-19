class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i=0; i<haystack.length(); i++) {
            int j=0;
            boolean flag = true;

            for(j=0; j<needle.length(); j++) {
                if(i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return i;
        }

        return -1;
    }
}