class Solution {

    private boolean isExists(List<Integer>[] graph, int source, int destination, boolean[] visited) {
        if(source == destination)
            return true;
        
        visited[source] = true;

        List<Integer> adj = graph[source];
        boolean exists = false;

        for(int v : adj) {
            if(!visited[v]) 
                exists = exists || isExists(graph, v, destination, visited);
        }

        return exists;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        return isExists(graph, source, destination, visited);
    }
}