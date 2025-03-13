class Solution {

    int[] DIR_X = {1, -1, 0, 0};
    int[] DIR_Y = {0, 0, 1, -1};

    private boolean isValid(int i, int j, int m, int n, int parent_i, int parent_j) {
        return i >= 0 && j >= 0 && i < m && j < n && !(parent_i == i && parent_j == j);
    }

    private boolean dfs(char[][] grid, boolean[][] isVisited, int i, int j, int parent_i, int parent_j, int m, int n) {

        if(isVisited[i][j]) {
            return true;
        }

        isVisited[i][j] = true;
        boolean ans = false;

        for(int p=0; p<4; p++) {
            int new_i = i + DIR_X[p];
            int new_j = j + DIR_Y[p];
            if(isValid(new_i, new_j, m, n, parent_i, parent_j) && grid[i][j] == grid[new_i][new_j]) {
                ans = ans || dfs(grid, isVisited, new_i, new_j, i, j, m, n);
            } 
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