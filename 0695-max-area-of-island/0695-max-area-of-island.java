class Solution {
    private boolean isValid(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        return i >=0 && j>=0 && i <m && j<n && !visited[i][j] && grid[i][j] == 1;
    }

    private int traverseIsland(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if(!isValid(grid, i, j, m, n, visited)) 
            return 0;
        
        visited[i][j] = true;
        return 1 + traverseIsland(grid, i+1, j, m, n, visited)
                    + traverseIsland(grid, i, j+1, m, n, visited)
                    + traverseIsland(grid, i-1, j, m, n, visited)
                    + traverseIsland(grid, i, j-1, m, n, visited);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                   maxArea = Math.max(maxArea, traverseIsland(grid, i, j, m, n, visited));
                }
            }
        }

        return maxArea;
    }
    
}