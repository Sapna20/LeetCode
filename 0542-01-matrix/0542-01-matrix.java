class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dirA = {-1, 0, 1, 0};
    int[] dirB = {0, -1, 0, 1};

    private boolean isValidPair(int row, int col, int m, int n) {
        return row < m && row >=0 && col < n && col >= 0;
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distMat = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    distMat[i][j] = 0;
                    q.offer(new Pair(i, j));
                } else {
                    distMat[i][j] = -1;
                }
            }
        }

        int dist = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Pair node = q.poll();

                for(int j=0; j<4; j++) {
                    int nbrRow = node.row + dirA[j];
                    int nbrCol = node.col + dirB[j];

                    if(isValidPair(nbrRow, nbrCol, m, n) && distMat[nbrRow][nbrCol] == -1) {
                        q.offer(new Pair(nbrRow, nbrCol));
                        distMat[nbrRow][nbrCol] = dist;
                    }
                }
            }
            dist++;
        }

        return distMat;
    }
}