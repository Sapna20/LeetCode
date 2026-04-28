class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<Set<Character>>();
        List<Set<Character>> cols = new ArrayList<Set<Character>>();
        List<List<Set<Character>>> boxes = new ArrayList<List<Set<Character>>>();

        for(int i=0; i<9; i++) {
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            rows.add(row);
            cols.add(col);
        }

        for(int i=0; i<3; i++) {
            List<Set<Character>> box_row = new ArrayList<Set<Character>>();
            for(int j=0; j<3; j++) {
                Set<Character> box = new HashSet<Character>();
                box_row.add(box);
            }
            boxes.add(box_row);
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char x = board[i][j];

                if(x == '.') continue;

                Set<Character> row = rows.get(i);
                Set<Character> col = cols.get(j);
                Set<Character> box = boxes.get(i/3).get(j/3);

                if(row.contains(x) || col.contains(x) || box.contains(x))
                    return false;
                
                row.add(x); 
                col.add(x);
                box.add(x);
            }
        } 
        return true;
        
    }
}