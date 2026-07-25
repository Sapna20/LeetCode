class Solution {

    private int[] dirA = {1, 0, -1, 0};
    private int[] dirB = {0, 1, 0, -1};

    private boolean isValid(int row, int col, int m, int n) {
        return row < m && col < n && row >= 0 && col >=0;
    }

    private boolean detectCycle(char[][] grid, boolean[][] visited, int row, int col, int m, int n, int pRow, int pCol) {
        visited[row][col] = true;
        boolean cycle = false;
        for(int i=0; i<4; i++) {
            int nRow = row + dirA[i];
            int nCol = col + dirB[i];
            if(isValid(nRow, nCol, m, n) && grid[row][col] == grid[nRow][nCol]) {
                if(!visited[nRow][nCol]) {
                    cycle = cycle || detectCycle(grid, visited, nRow, nCol, m, n, row, col);
                    if(cycle) {
                        return cycle;
                    }
                } else if (!(pRow == nRow && pCol == nCol)) {
                    return true;
                }
            }
        }
        return cycle;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        boolean cycle = false;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    cycle = cycle || detectCycle(grid, visited, i, j, m, n, -1, -1);
                }
            }
        }

        return cycle;
    }
}