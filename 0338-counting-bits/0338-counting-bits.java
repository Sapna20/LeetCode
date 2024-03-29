class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n>=1) {
            ans[1] = 1;
        }

        for(int i=2; i<=n; i++) {
            ans[i] = i%2 == 0 ? ans[i/2] : ans[i-1]+1; 
        }

        return ans;
    }
}