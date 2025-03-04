class Solution {

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {
        visited[source] = true;
        boolean ans = false;

        for(int nb : graph.get(source)) {
            if(nb == destination) 
                return true;
            if(!visited[nb])
                ans = ans || dfs(graph, nb, destination, visited);
        }
        return ans;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(edges.length == 0) {
            return source == destination;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if(map.containsKey(a)) {
                List<Integer> nb = map.get(a);
                nb.add(b);
                map.put(a, nb);
            } else {
                List<Integer> nb = new ArrayList<>();
                nb.add(b);
                map.put(a, nb);
            }

            if(map.containsKey(b)) {
                List<Integer> nb = map.get(b);
                nb.add(a);
                map.put(b, nb);
            } else {
                List<Integer> nb = new ArrayList<>();
                nb.add(a);
                map.put(b, nb);
            }
        }

        return dfs(map, source, destination, visited);
    }
}