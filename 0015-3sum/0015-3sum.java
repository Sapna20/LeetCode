class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i=0; i<n-1; i++) {
            if(nums[i] > 0) break;
            if(i>0 && nums[i-1] == nums[i]) continue;
            int l = i+1;
            int r = n-1;
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    List<Integer> ls = new ArrayList<Integer> ();
                    ls.addAll(Arrays.asList(nums[i], nums[l], nums[r]));
                    ans.add(ls);
                    while(l+1 < n && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while(r > 0 && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }

        return ans;
    }
}