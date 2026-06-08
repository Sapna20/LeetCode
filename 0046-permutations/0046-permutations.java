class Solution {

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<List<Integer>> solve(int[] nums, List<List<Integer>> ans, int idx) {
        if(idx == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return ans;
        }

        for(int i=idx; i<nums.length; i++) {
            swap(idx, i, nums);
            solve(nums, ans, idx+1);
            swap(i, idx, nums);
        }

        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        return solve(nums, new ArrayList<List<Integer>>(), 0);
    }
}