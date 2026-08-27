class Solution {

    private List<List<Integer>> subsets;

    private void getSubsets(int[] nums, int n, List<Integer> list) {
        if(n < 0) {
            subsets.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[n]);
        getSubsets(nums, n-1, list);
        list.remove(list.size()-1);
        getSubsets(nums, n-1, list);

        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<List<Integer>>();
        getSubsets(nums, nums.length-1, new ArrayList<Integer>());
        return subsets;
    }
}