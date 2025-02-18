class Solution {
    private boolean isValidLand(int[][] grid, int i, int j, boolean[][] isVisited) {
        return i < grid.length && i >= 0 && j < grid[0].length && j>=0 && grid[i][j] == 1 && !isVisited[i][j];
    }

    private int getIslandArea(int[][] grid, boolean[][] isVisited, int i, int j) {
        if(!isValidLand(grid, i, j, isVisited))
            return 0;
        
        isVisited[i][j] = true;

        return 1 + getIslandArea(grid, isVisited, i+1, j) +
                getIslandArea(grid, isVisited, i, j+1) +
                getIslandArea(grid, isVisited, i-1, j) +
                getIslandArea(grid, isVisited, i, j-1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n]; 
        int curr_max = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j] && grid[i][j] == 1) {
                    curr_max = Math.max(curr_max, getIslandArea(grid, isVisited, i, j));
                }
            }
        }

        return curr_max;     
    }
}