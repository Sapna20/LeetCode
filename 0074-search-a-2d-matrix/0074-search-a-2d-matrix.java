class Solution {
    private int findRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return end;
    }

    private boolean findElement(int[][] matrix, int target, int row) {
        int start = 0;
        int end = matrix[row].length-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        return findElement(matrix, target, row);
    }
}