class Solution {

    private int searchRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(matrix[mid][0] == target) {
                return mid;
            } else if(target < matrix[mid][0]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return end;
    }

    private boolean searchTarget(int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(matrix[row][mid] == target) {
                return true;
            } else if(target < matrix[row][mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = searchRow(matrix, target);

        if(idx < 0 || idx >= matrix.length) {
            return false;
        }

        return searchTarget(matrix, target, idx);
    }
}