class Solution {

    private int[] dirA = {1, 0, -1, 0};
    private int[] dirB = {0, 1, 0, -1};

    private boolean isValid(int row, int col, int m, int n) {
        return row < m && col < n && row >=0 && col >= 0;
    }
 
    private void dfs(int[][] heights, boolean[][] oceanCover, int row, int col, int m, int n) {
        oceanCover[row][col] = true;

        for(int i=0; i<4; i++) {
            int nRow = row + dirA[i];
            int nCol = col + dirB[i];
            if(isValid(nRow, nCol, m, n) 
            && !oceanCover[nRow][nCol] 
            && heights[nRow][nCol] >= heights[row][col]) {
                dfs(heights, oceanCover, nRow, nCol, m, n);
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] po = new boolean[m][n];
        boolean[][] ao = new boolean[m][n];

        for(int i=0; i<m; i++) {
            if(!po[i][0]) {
                dfs(heights, po, i, 0, m, n);
            }
        }

        for(int i=0; i<n; i++) {
            if(!po[0][i]) {
                dfs(heights, po, 0, i, m, n);
            }
        }

        for(int i=0; i<m; i++) {
            if(!ao[i][n-1]) {
                dfs(heights, ao, i, n-1, m, n);
            }
        }

        for(int i=0; i<n; i++) {
            if(!ao[m-1][i]) {
                dfs(heights, ao, m-1, i, m, n);
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(po[i][j] && ao[i][j]) {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(i);
                    ls.add(j);
                    ans.add(ls);
                }
            }
        }

        return ans;
    }
}