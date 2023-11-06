class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        String ans = "";

        for(int i=0; i<n; i++) {
            int count = 1;
            while(i+1 < n && chars[i] == chars[i+1]) {
                count++;
                i++;
            }
            ans += chars[i];
            if(count > 1) {
                ans += Integer.toString(count);
            }
        }

        for(int i=0; i<ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }

        return ans.length();
    }
}