class Solution {

    private List<List<String>> res;

    Solution() {
        res = new ArrayList<List<String>>();
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // check vertically
        for(int i=0; i<n; i++) {
            if(board[i][col] == 'Q') 
                return false;
        }

        // check diagonal source to top-left corner
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check diagonal source to bottom-right corner
        for(int i=row, j=col; i<n && j<n; i++, j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check diagonal source to top-right corner
        for(int i=row, j=col; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check diagonal source to bottom-left corner
        for(int i=row, j=col; i<n && j>=0; i++, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    private void solve(char[][] board, int row, int n) {
        if(row == n) {
            List<String> ls = new ArrayList<String>();
            for(int i=0; i<n; i++) {
                String str = "";
                for(int j=0; j<n; j++) {
                    str += board[i][j];
                }
                ls.add(str);
            }
            res.add(ls);
        }

        for(int col=0; col<n; col++) {
            if(isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, row+1, n);
                board[row][col] = '.';
            }
        }

        return;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n);

        return res;
    }
}