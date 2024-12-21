class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int i=0; 
        int j=0;

        for(i=0; i<n; i++) {
            int sum = 0;
            for(j=i; j<n; j++) {
                sum += nums[j];
                if(sum==k) {
                    count++;
                }
            }
        }
        // while(j<n && i<=j) {
        //     if(sum == k) {
        //         count++;
        //         j++;
        //         if(j<n) {
        //             sum = sum+nums[j];
        //         }
        //     } else if(sum > k) {
        //         sum = sum - nums[i];
        //         i++;
        //     } else if(sum < k) {
        //         if(nums[i] < 0) {
        //             sum = sum - nums[i];
        //             i++;
        //             j++;
        //             if(j<n) {
        //                 sum = sum+nums[j];
        //             }
        //         } else {
        //             j++;
        //             if(j<n) {
        //                 sum = sum+nums[j];
        //             }
        //         }

        //     }
        // }
        return count;
    }
}