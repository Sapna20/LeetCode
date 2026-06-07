class Solution {

    private List<List<Integer>> solve(int[] nums, int idx, ArrayList<List<Integer>> ans, List<Integer> ls) {
        if(idx == nums.length) {
            ans.add(new ArrayList(ls));
            return ans;
        }

        ls.add(nums[idx]);
        solve(nums, idx+1, ans, ls);
        ls.remove(ls.size()-1);
        
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }
        solve(nums, idx+1, ans, ls);

        return ans;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solve(nums, 0, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
}