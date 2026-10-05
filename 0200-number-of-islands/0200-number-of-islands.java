class Solution {

    int[] dirA = new int[]{-1, 0, 1, 0};
    int[] dirB = new int[]{0, 1, 0, -1};

    private boolean isValid(int row, int col, int m, int n) {
        return row < m && col < n && row >=0 && col >= 0;
    }

    private void traceIslands(char[][] grid, boolean[][] visited, int row, int col, int m, int n) {
        visited[row][col] = true;

        for(int i=0; i<4; i++) {
            int nrow = row + dirA[i];
            int ncol = col + dirB[i];
            if(isValid(nrow, ncol, m, n) && !visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                traceIslands(grid, visited, nrow, ncol, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    traceIslands(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}