class Solution {
    private void generateSubsets(int[] nums, int i, List<Integer> current, List<List<Integer>> subsets) {
        if(i==nums.length) {
            subsets.add(new ArrayList<Integer>(current));
            return;
        }

        current.add(nums[i]);
        generateSubsets(nums, i+1, current, subsets);
        current.remove(current.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }

        generateSubsets(nums, i+1, current, subsets);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        generateSubsets(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }
}