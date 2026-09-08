class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<int[]>();
        int j = 0, n = intervals.length;

        while(j < n) {
            int i = j;
            int lower = intervals[i][0];
            int upper = intervals[j][1];
            while(j+1 < n && upper >= intervals[j+1][0]) {
                upper = Math.max(upper, intervals[j+1][1]);
                j++;
            }
            
            int[] arr = new int[]{lower, upper};

            list.add(arr);
            j++;
        }

        int[][] ans = new int[list.size()][2];

        for(int i=0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}