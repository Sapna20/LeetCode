class Solution {
    public int countPalindromicSubsequence(String s) {
        boolean[] visited = new boolean[26];    
        int ans = 0;

        for(int i=0; i<s.length(); i++) {
            if(visited[s.charAt(i)-'a'])
                continue;
            for(int j=s.length()-1; j>i; j--) {
                if(s.charAt(i) == s.charAt(j) && !visited[s.charAt(i) - 'a']){
                    boolean[] unq = new boolean[26];
                    for(int k=i+1; k<j; k++) {
                        if(!unq[s.charAt(k) - 'a']) {
                            unq[s.charAt(k) - 'a'] = true;
                            ans++;
                        }
                    }
                    visited[s.charAt(i) - 'a'] = true;
                    break;
                }
            }
        }
        return ans;
    }
}