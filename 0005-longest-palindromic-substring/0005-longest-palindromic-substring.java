class Solution {

    private String solveBruteForce(String s) {
        // check palindrome for every substring - O(n) palindrome check
        // travserse through all possible substring using 2 for loops - O(n^2)

        // T(n) = O(n^3)
        return "";
    }

    private String solveDP(String s) {
        int n = s.length();
        if(n==0)
            return s;

        int max_so_far = 1;
        String ans = s.substring(0,1);

        boolean[][] dp = new boolean[n][n];

        // fill diagonal upper half
        for(int k=0; k<n; k++) {
            for(int i=0, j=k; i<n-k && j<n; i++, j++) {
                if(i==j) {  // fill diagonal, one character
                    dp[i][j] = true;

                } else if (k==1 && s.charAt(i) == s.charAt(j)) { // fill for two characters
                    dp[i][j] = true;
                    if(max_so_far < j-i+1) {
                        max_so_far = j-i+1;
                        ans = s.substring(i, j+1);
                    }

                } else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) { // check for border characters
                    dp[i][j] = true;
                    if(max_so_far < j-i+1) {
                        max_so_far = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }

        return ans;
    }

    // private String checkPalindromeCustom(String s, Integer max_so_far, String ans, int l, int r, int n) {
    //         while(l >= 0 && r < n) {
    //             if(s.charAt(l) == s.charAt(r)) {
    //                 if (max_so_far < r-l+1) {
    //                     max_so_far = r-l+1;
    //                     ans = s.substring(l, r+1);
    //                 }
    //             }
    //             l--;
    //             r++;
    //         }

    //         return ans;
    // }

    // private String solveTwoPointer(String s) {
    //     int n = s.length();
    //     int max_so_far = 0;
    //     String ans = "";

    //     for(int k=0; k<n; k++) {
    //         // odd length palindrome check
    //         int l=k;
    //         int r=k;

    //         ans = checkPalindromeCustom(s, max_so_far, ans, l, r, n);
    //         max_so_far = ans.length();
            
    //         // even length palindrome check
    //         l=k;
    //         r=k+1;
    //         ans = checkPalindromeCustom(s, max_so_far, ans, l, r, n);
    //         max_so_far = ans.length();
    //     }

    //     return ans;
    // }

    public String longestPalindrome(String s) {
        return solveDP(s);
    }
}