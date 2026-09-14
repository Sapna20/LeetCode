class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for(int i=0; i<32; i++) {
            ans = ans << 1;
            int temp = n & 1;
            ans = ans | temp;
            n = n >> 1;
        }

        return ans;
    }
}