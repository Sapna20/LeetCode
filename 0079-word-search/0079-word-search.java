class Solution {

    private int[] dirA = new int[]{-1, 0, 1, 0};
    private int[] dirB = new int[]{0, -1, 0, 1};

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    private boolean solve(char[][] board, String word, int strIdx, int i, int j, int m, int n, boolean[][] visited) {
        
        if(word.length() == strIdx) {
            return true;
        } 
        
        visited[i][j] = true;
        boolean isPresent = false;
        for(int idx=0; idx<4; idx++) {
            int row = i + dirA[idx];
            int col = j + dirB[idx];
            if(isValid(row, col, m, n) && !visited[row][col] && word.charAt(strIdx) == board[row][col]) {
                isPresent = isPresent || solve(board, word, strIdx+1, row, col, m, n, visited);
            }
        }
        visited[i][j] = false;
        return isPresent;
    }   

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        boolean isPresent = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && board[i][j] == word.charAt(0)) {
                    isPresent = isPresent || solve(board, word, 1, i, j, m, n, visited);
                }
            }
        }

        return isPresent;
    }
}