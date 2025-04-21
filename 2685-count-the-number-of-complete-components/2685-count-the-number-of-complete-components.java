class Solution {

    private void dfs(List<Integer>[] graph, boolean[] visited, int u, int[] nodeEdgeCount) {
        visited[u] = true;

        List<Integer> adj = graph[u];
        nodeEdgeCount[0]++;
        nodeEdgeCount[1] += adj.size();

        for(int v : adj) {
            if(!visited[v])
                dfs(graph, visited, v, nodeEdgeCount);
        }
        return;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int ans = 0;

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
        
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=0; i<n; i++) {
            int[] nodeEdgeCount = new int[2];
            if(!visited[i]) {
                dfs(graph, visited, i, nodeEdgeCount);
            
                int nodeCount = nodeEdgeCount[0];
                int edgeCount = nodeEdgeCount[1];
                if(edgeCount == nodeCount*(nodeCount-1))
                    ans++;
            }
            visited[i] = true;
        }

        return ans;
    }
}