class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i, memo));
        }
        return ans;
    }

    private int dfs(int[] arr, int d, int i, int[] memo) {
        if (memo[i] != 0) return memo[i];

        int n = arr.length;
        int best = 1; // at minimum, we visit index i itself

        // Jump right: i+1, i+2, ..., i+d
        for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
            if (arr[j] >= arr[i]) break; // blocked by a taller/equal bar
            best = Math.max(best, 1 + dfs(arr, d, j, memo));
        }

        // Jump left: i-1, i-2, ..., i-d
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
            if (arr[j] >= arr[i]) break; // blocked
            best = Math.max(best, 1 + dfs(arr, d, j, memo));
        }

        memo[i] = best;
        return best;
    }
}