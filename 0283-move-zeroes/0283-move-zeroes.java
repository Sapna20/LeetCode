class Solution {
    public void moveZeroes(int[] nums) {
        int i=0, j=0, n=nums.length;

        while(i<n && j<n) {
            while(i<n && nums[i] != 0) {
                i++;
            }

            j = i+1;
            while(j<n && nums[j] == 0) {
                j++;
            }

            if(j<n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        return;
    }
}