class Solution {

    int[] dirA = new int[]{-1, 0, 1, 0};
    int[] dirB = new int[]{0, 1, 0, -1};

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    private void dfs(char[][] board, boolean[][] grid, int m, int n, int row, int col) {
        grid[row][col] = true;

        for(int i=0; i<4; i++) {
            int nrow = row + dirA[i];
            int ncol = col + dirB[i];
            if(isValid(nrow, ncol, m, n) && board[nrow][ncol] == 'O' && !grid[nrow][ncol]) {
                dfs(board, grid, m, n, nrow, ncol);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] grid = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(board[i][j] == 'O' && !grid[i][j]) {
                        dfs(board, grid, m, n, i, j);
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!grid[i][j]) {
                    board[i][j] = 'X';
                } 
            }
        }
    }
}