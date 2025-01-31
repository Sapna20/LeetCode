class Solution {

    private boolean solve(int i, int j, int k, char[][] board, String word, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if(i >= m || j >= n || i<0 || j<0 || k >= word.length() || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        if(k+1 == word.length()) {
            return true;
        }
        // System.out.println("" + i + " " + j + board[i][j]);
        visited[i][j] = true;
        if(solve(i+1, j, k+1, board, word, visited) || solve(i-1, j, k+1, board, word, visited)|| solve(i, j+1, k+1, board, word, visited) || solve(i, j-1, k+1, board, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(solve(i, j, 0, board, word, visited)) {
                        return true;
                    } else {
                        for(int p=0; p<m; p++) {
                            for(int q=0; q<n; q++) {
                                visited[p][q] = false;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}