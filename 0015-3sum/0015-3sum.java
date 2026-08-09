class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i=0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = n-1;

            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while(right > 0 && nums[right] == nums[right-1]) {
                        right--;
                    }
                    while(left < n-1 && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
        
    }
}