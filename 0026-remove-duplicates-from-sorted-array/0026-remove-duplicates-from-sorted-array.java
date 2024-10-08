class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=0, n=nums.length;
        while(i<n && j<n) {
            while( j + 1 < n && nums[j] == nums[j+1]) {
                j++;
            }
            if(j+1 == n) 
                return i+1;
            nums[i+1] = nums[j+1];
            j++;
            i++;
        }

        return n;
    }
}