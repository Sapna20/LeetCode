class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        int n = intervals.length;
        int j=0;

        while(j < n) {
            int[] temp = new int[2];
            int a = intervals[j][0];
            int b = intervals[j][1];
            while( j < n-1 && b >= intervals[j+1][0] ) {
                b = Math.max(intervals[j+1][1], b);
                j++;
            }
            temp[0] = a;
            temp[1] = b;
            mergedIntervals.add(temp);
            j++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}