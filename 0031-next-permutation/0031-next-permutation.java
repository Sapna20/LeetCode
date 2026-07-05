class Solution {
    public void nextPermutation(int[] nums) {
        int swapJ = -1;
        int swapI = -1;
        for(int i=nums.length-1; i > 0; i--) {
            for(int j=i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    if(swapJ < j) {
                        swapJ = j;
                        swapI = i;
                    }
                    break;
                }
            }
        }
        if(swapJ != -1) {
            swap(nums, swapJ, swapI);  
        } 

        reverse(nums, swapJ+1, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}