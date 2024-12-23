class Solution {

    private void getValidCombinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> validCombinations) {
        if(index == candidates.length && target != 0) {
            return;
        }
        if(target == 0) {
            validCombinations.add(new ArrayList<Integer>(current));
            return;
        }

        if(target - candidates[index] >= 0) {
            current.add(candidates[index]);
            getValidCombinations(candidates, target - candidates[index], index+1, current, validCombinations);
            current.remove(current.size()-1);

            while(index + 1 < candidates.length && candidates[index] == candidates[index+1]) {
                index++;
            }
            getValidCombinations(candidates, target, index+1, current, validCombinations);

        } else {
            getValidCombinations(candidates, target, index+1, current, validCombinations);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> validCombinations = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        getValidCombinations(candidates, target, 0, current, validCombinations);

        return validCombinations;
    }
}