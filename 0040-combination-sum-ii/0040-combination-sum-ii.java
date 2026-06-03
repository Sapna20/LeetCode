class Solution {

    private List<List<Integer>> solve(int[] candidates, int target, int idx, List<Integer> ls, List<List<Integer>> ans) {
        if(idx == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<Integer>(ls));
            }
            return ans;
        }

        if(target - candidates[idx] >= 0) {
            ls.add(candidates[idx]);
            solve(candidates, target - candidates[idx], idx+1, ls, ans);
            ls.remove(ls.size()-1);
            while(idx < candidates.length-1 && candidates[idx] == candidates[idx+1]) {
                idx++;
            }
            solve(candidates, target, idx+1, ls, ans);
        } else {
            solve(candidates, target, idx+1, ls, ans);
        }

        return ans;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return solve(candidates, target, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
}