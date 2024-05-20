class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<Set<Character>>();
        List<Set<Character>> col = new ArrayList<Set<Character>>();

        List<List<Set<Character>>> grid = new ArrayList<List<Set<Character>>>();

        for(int i=0; i<9; i++) {
            Set<Character> r = new HashSet<Character>();
            row.add(r);
            Set<Character> c = new HashSet<Character>();
            col.add(c);
        }

        for(int i=0; i<3; i++) {
            List<Set<Character>> g = new ArrayList<Set<Character>>();
            grid.add(g);
            for(int j=0; j<3; j++) {
                Set<Character> item = new HashSet<Character>();
                grid.get(i).add(item);
            }
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(row.get(i).contains(c) || col.get(j).contains(c) || grid.get(i/3).get(j/3).contains(c)) {
                        return false;
                    } else {
                        row.get(i).add(c);
                        col.get(j).add(c);
                        grid.get(i/3).get(j/3).add(c);
                    }
                } 
            }
        }
        
        return true;

    }
}