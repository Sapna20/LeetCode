class Solution {

    private void dfs(int src, int[][] graph, boolean[] visited, List<Integer> currentPath, List<Integer> cycle) {
        visited[src] = true;
        int e = graph[src].length; 
        // for(int x : currentPath) {
        //     System.out.println(x + "--");
        // }
        // for(int x : cycle) {
        //     System.out.println(x + "**");
        // }
        // System.out.println(src + "&&");
        for(int i=0; i<e; i++) {
            int ngb = graph[src][i];
            if(currentPath.contains(ngb)) {
                cycle.addAll(currentPath);
                return;
            }
            if(!visited[ngb]) {
                currentPath.add(ngb);
                dfs(ngb, graph, visited, currentPath, cycle);
                currentPath.remove(currentPath.size()-1);
            }
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        List<Integer> temp = new ArrayList<>();
        List<Integer> cycle = new ArrayList<>();

        for(int i=0; i<v; i++) {
            if(true) {
                temp.add(i);
                dfs(i, graph, visited, temp, cycle);
                temp.remove(temp.size()-1);
                Arrays.fill(visited, false);
            }
        }

        for(int i=0; i<v; i++) {
            if(!cycle.contains(i)) {
                temp.add(i);
            }
        }
        return temp;
    }
}