class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1;
        int currInc=1, currDec=1;
        int n=nums.length;

        for(int i=1; i<n; i++) {
            if(nums[i-1] > nums[i]) {
                currDec++;
                dec = Math.max(currDec, dec);
            } else {
                currDec = 1;
            }

            if(nums[i-1] < nums[i]) {
                currInc++;
                inc = Math.max(currInc, inc);
            } else {
                currInc = 1;
            }
        }

        return inc > dec ? inc : dec;
    }
}