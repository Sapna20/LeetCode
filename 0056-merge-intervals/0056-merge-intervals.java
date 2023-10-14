class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i, j) -> {return i[0]-j[0];});

        List<List<Integer>> ansLs = new ArrayList<List<Integer>> ();

        for(int i=0; i<n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i+1 < n && end >= intervals[i+1][0]) {
                end = Math.max(intervals[i+1][1], end);
                i++;
            }
            List<Integer> ls = new ArrayList<Integer> ();
            ls.add(start);
            ls.add(end);
            ansLs.add(ls);
        }

        int[][] ans = new int[ansLs.size()][2];
        int j=0;
        for(List<Integer> list : ansLs) {
            ans[j][0] = list.get(0);
            ans[j][1] = list.get(1);
            j++;
        }
        return ans;
    }
}