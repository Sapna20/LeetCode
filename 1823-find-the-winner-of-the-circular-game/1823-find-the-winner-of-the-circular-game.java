class Solution {

    private int ans = 0;

    private void solve(int n, int k, int start, List<Integer> ls) {
        if(n == 1) {
            this.ans = ls.get(0);
        }

        if(n > 0) {
            int index = (start+k-1) % n;
            ls.remove(index);
            solve(ls.size(), k, index, ls);
        }

    }

    public int findTheWinner(int n, int k) {
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            ls.add(i);
        }
        solve(n, k, 0, ls);
        return this.ans;
    }
}