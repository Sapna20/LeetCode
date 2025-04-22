class Solution {

    private int countDfsReachableNodes(List<Integer>[] graph, int src, int[] restricted, boolean[] visited) {
        visited[src] = true;
        int ans = 1;
        for(int x : graph[src]) {
            if(!visited[x] && isNotRestricted(x, restricted)) {
                ans += countDfsReachableNodes(graph, x, restricted, visited);
            }
        }

        return ans;
    }

    private boolean isNotRestricted(int x, int[] restricted) {
        for(int y : restricted) {
            if(x == y)
                return false;
        }
        return true;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
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

        return countDfsReachableNodes(graph, 0, restricted, visited);
    }
}