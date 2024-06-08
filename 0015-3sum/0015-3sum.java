class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i=0; i<n-1; i++) {
            while(i>0 && i<n && nums[i-1] == nums[i]) {
                i++;
            }
            int j=i+1, k=n-1;
            while(j<k && j<n) {
                int temp = nums[i] + nums[j] + nums[k];
                if( temp == 0 ) {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    ans.add(ls);
                    while(j<n-1 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    j++;
                } else if (temp < 0) {
                    j++;
                } else if (temp > 0) {
                    k--;
                }
            }
        }

        return ans;
    }
}