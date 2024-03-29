class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i=0, j=n, k=0;

        while(k < 2*n) {
            if(k%2 == 0) {
                ans[k] = nums[i];
                i++; k++;
            } else {
                ans[k] = nums[j];
                k++; j++;
            }
        }

        return ans;
    }
}