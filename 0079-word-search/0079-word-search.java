class Solution {


    private boolean isValid(char[][] board, String word, int idx, int i, int j, int m, int n, boolean[][] isVisited) {
        return i < m && i >= 0
            && j < n && j >= 0
            && idx < word.length()
            && !isVisited[i][j]
            && word.charAt(idx) == board[i][j];
    }

    private boolean checkGrid(char[][] board, String word, int idx, int i, int j, int m, int n, boolean[][] isVisited) {
        if(!isValid(board, word, idx, i, j, m, n, isVisited)) {
            return false;
        }

        if(idx == word.length()-1)
            return true;
        
        isVisited[i][j] = true;

        boolean found = checkGrid(board, word, idx+1, i+1, j, m, n, isVisited) 
        || checkGrid(board, word, idx+1, i, j+1, m, n, isVisited)
        || checkGrid(board, word, idx+1, i-1, j, m, n, isVisited)  
        || checkGrid(board, word, idx+1, i, j-1, m, n, isVisited);   

        isVisited[i][j] = false;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
    
        boolean[][] isVisited = new boolean[m][n];
        boolean found = false;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                found = found || checkGrid(board, word, 0, i, j, m, n, isVisited);
                if(found) {
                    return found;
                }
            }
        }
        
        return false;
         
    }
}