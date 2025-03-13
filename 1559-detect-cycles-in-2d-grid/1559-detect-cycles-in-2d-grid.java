class Solution {

    private boolean isValid(int i, int j, int m, int n, int parent_i, int parent_j) {
        return i >= 0 && j >= 0 && i < m && j < n && !(parent_i == i && parent_j == j);
    }

    private boolean dfs(char[][] grid, boolean[][] isVisited, int i, int j, int parent_i, int parent_j, int m, int n) {

        if(isVisited[i][j]) {
            return true;
        }

        isVisited[i][j] = true;
        boolean ans = false;
        
        if(isValid(i+1, j, m, n, parent_i, parent_j) && grid[i][j] == grid[i+1][j]) {
            ans = ans || dfs(grid, isVisited, i+1, j, i, j, m, n);
        } 
        if(isValid(i, j+1, m, n, parent_i, parent_j) && grid[i][j] == grid[i][j+1]) {
            ans = ans || dfs(grid, isVisited, i, j+1, i, j, m, n);
        } 
        if(isValid(i-1, j, m, n, parent_i, parent_j) && grid[i][j] == grid[i-1][j]) {
            ans = ans || dfs(grid, isVisited, i-1, j, i, j, m, n);
        } 
        if(isValid(i, j-1, m, n, parent_i, parent_j) && grid[i][j] == grid[i][j-1]) {
            ans = ans || dfs(grid, isVisited, i, j-1, i, j, m, n);
        }
        return ans;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        if(m == 0) {
            return false;
        }
        int n = grid[0].length;

        boolean[][] isVisited = new boolean[m][n];
        boolean ans = false;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j]) {
                    ans = ans || dfs(grid, isVisited, i, j, -1, -1, m, n);
                }
                isVisited[i][j] = true; 
            }
        }
        
        return ans;
    }
}