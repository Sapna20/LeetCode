class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int ans = 1;
        for(int i=0; i<n; i++) {
            lis[i] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    if(lis[i] > ans) {
                        ans = lis[i];
                    }
                }
            }
        }
        return ans;
    }
}