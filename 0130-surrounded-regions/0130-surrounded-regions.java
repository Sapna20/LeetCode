class Solution {

    private int[] dirA = new int[]{1, 0, -1, 0};
    private int[] dirB = new int[]{0, 1, 0, -1};

    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n) {
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        grid[row][col] = 'X';
        for(int i=0; i<4; i++) {
            int nrow = row + dirA[i];
            int ncol = col + dirB[i];
            dfs(grid, visited, nrow, ncol, m, n);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        char[][] grid = new char[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = board[i][j];
            }
        }

        for(int i=0; i<m; i++) {
            // dfs on first column
            dfs(grid, visited, i, 0, m, n);

            //dfs on last column
            dfs(grid, visited, i, n-1, m, n);
        }

        for(int j=0; j<n; j++) {
            // dfs on first row
            dfs(grid, visited, 0, j, m, n);

            //dfs on last row
            dfs(grid, visited, m-1, j, m, n);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}