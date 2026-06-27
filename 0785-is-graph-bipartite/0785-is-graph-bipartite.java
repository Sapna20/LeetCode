class Solution {

    private boolean solve(int[][] graph, int node, boolean[] visited, boolean[] flag) {
        visited[node] = true;
        boolean ans = true;
        
        for(int i=0; i<graph[node].length; i++) {
            int adj = graph[node][i];
            if(!visited[adj]) {
                flag[adj] = !flag[node];
                ans = ans && solve(graph, adj, visited, flag);
                if(!ans) {
                    return false;
                }
            } else if (flag[adj] == flag[node]) {
                return false;
            }
        }

        return ans;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] flag = new boolean[n];

        boolean ans = true;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                flag[i] = true;
                ans = ans && solve(graph, i, visited, flag); 
            }
        }
        
        return ans;
    }
}