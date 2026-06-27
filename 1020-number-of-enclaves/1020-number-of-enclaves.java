class Solution {

    private int[] dirA = new int[]{-1, 0, 1, 0};
    private int[] dirB = new int[]{0, 1, 0, -1};

    private void dfs(int[][] enclaves, int row, int col, int m, int n) {
        if(row >= m || row < 0 || col >= n || col < 0 || enclaves[row][col] == 0) {
            return;
        } 

        enclaves[row][col] = 0;

        for(int i=0; i<4; i++) {
            int nrow = row + dirA[i];
            int ncol = col + dirB[i];
            dfs(enclaves, nrow, ncol, m, n);
        }

        return;
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] enclaves = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                enclaves[i][j] = grid[i][j];
            }
        }

        for(int i=0; i<m; i++) {
            // run dfs on first column
            dfs(enclaves, i, 0, m, n);

            // run dfs on last column
            dfs(enclaves, i, n-1, m, n);
        }

        for(int j=0; j<n; j++) {
            // run dfs on first row
            dfs(enclaves, 0, j, m, n);

            // run dfs on last row
            dfs(enclaves, m-1, j, m, n);
        }

        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(enclaves[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}