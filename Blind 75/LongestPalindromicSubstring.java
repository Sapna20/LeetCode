// Given a string s, return the longest palindromic substring in s.

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1) return s;

        boolean[][] dp = new boolean[n][n]; 
        int max = 0, start = 0, end = 0;

        //outer for loop to identify upper diagonals and reduce size of diagonal until we reach corner of dp array
        for(int k=0; k<n; k++) {
            //inner for loop to traverse through diagonal
            for(int i=0, j=k; i<n-k && j<n; i++, j++) {
                if(i==j) {
                    dp[i][j] = true;
                    if(max < j-i+1) {
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                } else if(j==i+1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if(max < j-i+1) {
                            max = j-i+1;
                            start = i;
                            end = j;
                        }
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                        if(max < j-i+1) {
                            max = j-i+1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }
}
