class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m-1;

        while(start <= end) {
            int mid = (end - start)/2 + start;
            if(matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target) 
                end = mid-1;
            else
                start = mid+1;
        }
        System.out.println(end);

        if(end >= 0) {
            int row = end;
            
            start = 0;
            end = n-1;

            while(start <= end) {
                int mid = (end - start)/2 + start;
                if(matrix[row][mid] == target)
                    return true;
                else if (matrix[row][mid] > target) 
                    end = mid-1;
                else
                    start = mid+1;
            }
        }

        return false;

    }
}