class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[][] grid = new Set[3][3];

        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                grid[i][j] = new HashSet<Character>(); 
            }
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {

                char ch = board[i][j];

                if(ch < '0' || ch > '9') 
                    continue;

                // check validity -- row -- col -- grid
                if(rows[i].contains(ch)
                    || cols[j].contains(ch)
                    || grid[i/3][j/3].contains(ch)) {
                    return false;
                }

                rows[i].add(ch);
                cols[j].add(ch);
                grid[i/3][j/3].add(ch);
            }
        }

        return true;
    }
}