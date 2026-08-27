class Solution {

    private List<List<Integer>> ans;

    private void findCombinations(int[] candidates, int target, int n, List<Integer> list) {
        if(n < 0) {
            if(target == 0) {
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        } 

        if(target - candidates[n] >= 0) {
            list.add(candidates[n]);
            findCombinations(candidates, target-candidates[n], n, list);
            list.remove(list.size()-1);
            findCombinations(candidates, target, n-1, list);
        } else {
            findCombinations(candidates, target, n-1, list);
        }

        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        findCombinations(candidates, target, candidates.length-1, new ArrayList<Integer>());
        return ans;
    }
}