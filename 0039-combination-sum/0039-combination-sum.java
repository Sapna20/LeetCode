class Solution {

    private List<List<Integer>> solve(int[] candidates, int target, int idx, List<List<Integer>> ansList, List<Integer> currList) {
        if(idx == candidates.length) {
            return ansList;
        }

        if(target - candidates[idx] > 0) {
            currList.add(candidates[idx]);
            solve(candidates, target - candidates[idx], idx, ansList, currList);
            currList.remove(currList.size()-1);
            solve(candidates, target, idx+1, ansList, currList);
        } else if(target - candidates[idx] == 0) {
            currList.add(candidates[idx]);
            ansList.add(new ArrayList<Integer>(currList));
            currList.remove(currList.size()-1);
            solve(candidates, target, idx+1, ansList, currList);
        } else {
            solve(candidates, target, idx+1, ansList, currList);
        }

       return ansList;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return solve(candidates, target, 0, new ArrayList<List<Integer>>(), new ArrayList<Integer> ());
    }
}