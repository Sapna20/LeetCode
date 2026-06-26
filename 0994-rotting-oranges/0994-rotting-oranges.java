class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        int fresh_count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = 2;
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    fresh_count++;
                } else {
                    visited[i][j] = 0;
                }
                
            }
        }

        int[] dirA = new int[]{0, -1, 0, 1};
        int[] dirB = new int[]{-1, 0, 1, 0};
        int time = 0;

        while(!queue.isEmpty() && fresh_count > 0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int row = queue.peek()[0];
                int col = queue.peek()[1];
                
                queue.poll();
                for(int j=0; j<4; j++) {
                    int nrow = dirA[j] + row;
                    int ncol = dirB[j] + col;

                    if(nrow < m && nrow >= 0 && ncol < n && ncol >= 0 && visited[nrow][ncol] == 1) {
                        visited[nrow][ncol] = 2;
                        queue.offer(new int[]{nrow, ncol});
                        fresh_count--;
                    }
                }
            }
            time++;
        }

        return fresh_count == 0 ? time : -1;
    }
}