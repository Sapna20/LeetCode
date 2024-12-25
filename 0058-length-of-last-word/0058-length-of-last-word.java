class Solution {
    
    public int lengthOfLastWord(String s) {
    
        boolean wordStarted = false;
        int ans = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                if(!wordStarted) 
                    continue;
                break;
            } else {
                if(!wordStarted)
                    wordStarted = true;
                ans++;
            }
        }

        return ans;
    }
}