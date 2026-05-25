class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        boolean[] reach = new boolean[n];
        reach[0] = true;

        // prefix[i] = number of reachable positions among indices 0..i-1
        int[] prefix = new int[n + 1];
        prefix[1] = 1;  // index 0 is reachable

        for (int j = 1; j < n; j++) {
            // window of valid launch positions for j: [j - maxJump, j - minJump]
            int lo = Math.max(0, j - maxJump);
            int hi = j - minJump;

            if (hi >= 0 && s.charAt(j) == '0') {
                // count reachable positions in [lo, hi] using prefix sums
                int countInWindow = prefix[hi + 1] - prefix[lo];
                if (countInWindow > 0) reach[j] = true;
            }

            // extend prefix sum to include index j
            prefix[j + 1] = prefix[j] + (reach[j] ? 1 : 0);
        }
        return reach[n - 1];
    }
}