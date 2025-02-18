class Solution {
    private boolean isValidLand(char[][] grid, int i, int j, boolean[][] isVisited) {
        return i < grid.length && i >= 0 && j < grid[0].length && j>=0 && grid[i][j] == '1' && !isVisited[i][j];
    }

    private void markVisitedLands(char[][] grid, boolean[][] isVisited, int i, int j) {
        if(!isValidLand(grid, i, j, isVisited))
            return;
        
        isVisited[i][j] = true;

        markVisitedLands(grid, isVisited, i+1, j);
        markVisitedLands(grid, isVisited, i, j+1);
        markVisitedLands(grid, isVisited, i-1, j);
        markVisitedLands(grid, isVisited, i, j-1);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n]; 
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j] && grid[i][j] == '1') {
                    markVisitedLands(grid, isVisited, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}