class Solution {
    public void moveZeroes(int[] nums) {
        int n = 1;
        int z = 0;

        while(z<n && n<nums.length && z<nums.length) {
            while( z<nums.length && nums[z] != 0) {
                z++;
            }
            n = z+1;

            while( n < nums.length && nums[n] == 0) {
                n++;
            }

            if(n < nums.length) {
                int temp = nums[z];
                nums[z] = nums[n];
                nums[n] = temp;
            }
        }

        return;
    }
}