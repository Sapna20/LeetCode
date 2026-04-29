class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i<n; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            int j=i+1, k=n-1;
            while(j<k) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    j++; continue;
                } 
                if(nums[j] + nums[k] == target) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}