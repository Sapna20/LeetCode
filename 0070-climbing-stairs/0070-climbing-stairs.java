class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n==2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int ans = b;

        for(int i=3; i<=n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
}