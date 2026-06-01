class Solution {

    private List<List<Integer>> solve(int[] nums, int idx, List<List<Integer>> ans, List<Integer> currList) {
        if(idx == nums.length) {
            ans.add(new ArrayList<Integer>(currList));
            return ans;
        }

        currList.add(nums[idx]);
        solve(nums, idx+1, ans, currList);
        currList.remove(currList.size()-1);
        solve(nums, idx+1, ans, currList);

        return ans;

    }

    public List<List<Integer>> subsets(int[] nums) {
        return solve(nums, 0, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
}