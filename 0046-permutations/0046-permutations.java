class Solution {

    private List<List<Integer>> ans;

    private void solve(int[] nums, int start) {
        if(start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) {
                list.add(x);
            }
            ans.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++) {
            swap(nums, start, i);
            solve(nums, start+1);
            swap(nums, start, i);
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        solve(nums, 0);
        return ans;
    }
}