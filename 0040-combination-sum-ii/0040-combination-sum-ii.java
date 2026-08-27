class Solution {

    private List<List<Integer>> ans;

    private void process(int[] nums, int target, int n, List<Integer> list) {
        if(n < 0) {
            if(target == 0) {
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }

        if(target - nums[n] >= 0) {
            list.add(nums[n]);
            process(nums, target-nums[n], n-1, list);
            list.remove(list.size()-1);
            while(n - 1 >= 0 && nums[n-1] == nums[n]) {
                n--;
            }
            process(nums, target, n-1, list);
        } else {
            process(nums, target, n-1, list);
        }

        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>> ();
        Arrays.sort(candidates);
        process(candidates, target, candidates.length-1, new ArrayList<Integer>());
        return ans;
    }
}