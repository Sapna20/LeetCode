class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = 0;
        rightArr[0] = 0;

        for(int i=n-2; i>=0; i--) {
            rightArr[i] = rightArr[i+1] + nums[i+1];
        }

        for(int i=1; i<n; i++) {
            leftArr[i] = leftArr[i-1] + nums[i-1];
        }

        for(int i=0; i<n; i++) {
            if(leftArr[i] == rightArr[i]) 
                return i;
        }

        return -1;
    }
}