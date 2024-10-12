class Solution {

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();



    private void solve(int[] nums, int index, List<Integer> ls) {
        if(index == nums.length) {
            ans.add(new ArrayList<Integer>(ls));
            return;
        }

        solve(nums, index+1, ls);
        ls.add(nums[index]);
        solve(nums, index+1, ls);
        ls.remove(ls.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ls = new ArrayList<Integer>();
        solve(nums, 0, ls);
        return ans;
    }
}