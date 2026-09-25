class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];
        int[] product = new int[n];
        prefixArr[0] = 1;
        suffixArr[n-1] = 1; 

        for(int i=1; i<n; i++) {
            prefixArr[i] = prefixArr[i-1]*nums[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            suffixArr[i] = suffixArr[i+1]*nums[i+1]; 
        } 

        for(int i=0; i<n; i++) {
            product[i] = prefixArr[i]*suffixArr[i];
        } 

        return product;
    }
}