class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] mergedIntervals = new int[n][2];
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int i=0;
        int j=0;
        while(i < n) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            i++;
            while(i < n && temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
                i++;
            }

            mergedIntervals[j] = temp;
            j++;
        }

        return Arrays.copyOfRange(mergedIntervals, 0, j);
    }
}