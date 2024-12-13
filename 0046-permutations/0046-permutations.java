class Solution {

    private void solve(int[] nums, int index, List<List<Integer>> ans) {
        if(index < 0) {
            List<Integer> ls = new ArrayList<Integer>();
            for(int x : nums) {
                ls.add(x);
            }
            ans.add(ls);
        }

        for(int i=index; i >=0; i--) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            solve(nums, index-1, ans);

            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp; 
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(nums, nums.length-1, ans);
        return ans;
    }
}