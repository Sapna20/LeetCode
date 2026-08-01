class Solution {

    private List<List<Integer>> getGraph(int V, int[][] edges, int[] indegree) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        return graph;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = getGraph(numCourses, prerequisites, indegree);

        Queue<Integer> q = new LinkedList<Integer>();
        int[] order = new int[numCourses];
        int ptr = 0;

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                order[ptr] = i;
                ptr++;
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int adj : graph.get(node)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.offer(adj);
                    order[ptr] = adj;
                    ptr++;
                }
            }
        }

        return ptr == numCourses ? order : new int[0];
    }
}