class Solution {

    private boolean isValid(int m, int n, int i, int j) {
        return i<m && j<n && i>=0 && j>=0;
    }

    private boolean isExist(char[][] board, String word, int i, int j, int index, boolean[][] isVisited) {
        int m = board.length;
        int n = board[0].length;
        if(index == word.length()) {
            return true;
        }

        if(!isValid(m, n, i, j) || isVisited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        isVisited[i][j] = true;

        boolean found = isExist(board, word, i+1, j, index+1, isVisited)
                || isExist(board, word, i-1, j, index+1, isVisited)
                || isExist(board, word, i, j+1, index+1, isVisited)
                || isExist(board, word, i, j-1, index+1, isVisited);

        isVisited[i][j] = false;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j] && isExist(board, word, i, j, 0, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }
}