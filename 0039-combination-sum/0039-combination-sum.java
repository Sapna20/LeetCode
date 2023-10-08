class Solution {

    public void solve(int[] arr, int sum, int i, List<Integer> ls, List<List<Integer>> ans) {
        if(sum==0) {
            ans.add(new ArrayList(ls));
            return;
        } else if(sum < 0 || i >= arr.length) {
            return;
        }

        if(sum - arr[i] >= 0) {
            ls.add(arr[i]);
            solve(arr, sum-arr[i], i, ls, ans);
            ls.remove(ls.size()-1);
            solve(arr, sum, i+1, ls, ans);

        } else {
            solve(arr, sum, i+1, ls, ans);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        solve(candidates, target, 0, ls, ans);
        return ans;
    }
}