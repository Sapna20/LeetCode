class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0; i<=n; i++) {
            int j=i; 
            while(j != 0) {
                if( (j & 1) == 1) {
                    ans[i] += 1;
                }
                j = j>>1;
            }
        }
        return ans;
    }
}