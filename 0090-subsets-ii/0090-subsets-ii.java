class Solution {
    List<List<Integer>> ans;

    private void solve(int[] nums, int idx, List<Integer> list) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        list.add(nums[idx]);
        solve(nums, idx+1, list);
        list.remove(list.size()-1);

        while(idx + 1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }

        solve(nums, idx+1, list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<Integer>());
        return ans;
    }
}