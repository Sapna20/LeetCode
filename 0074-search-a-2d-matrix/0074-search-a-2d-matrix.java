class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m-1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][0] < target){
                start = mid + 1;
            }
        }

        int ind = end;

        if( ind < m && ind > -1 ) {
            start = 0;
            end = n-1;

            while(start <= end) {
                int mid = (start + end)/2;
                if(matrix[ind][mid] == target) {
                    return true;
                } else if(matrix[ind][mid] > target) {
                    end = mid - 1;
                } else if (matrix[ind][mid] < target){
                    start = mid + 1;
                }
            }
        }

        return false;

        
    }
}