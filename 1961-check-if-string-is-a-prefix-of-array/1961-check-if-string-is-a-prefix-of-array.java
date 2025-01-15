class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String prefix = "";
        for(String word : words) {
            prefix = prefix + word;
            if(prefix.equals(s)) 
                return true;
        }

        return false;
    }
}