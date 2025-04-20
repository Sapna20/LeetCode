class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            inMap.put(u, inMap.getOrDefault(u, 0));
            inMap.put(v, inMap.getOrDefault(v, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : inMap.entrySet()) {
            if(entry.getValue() == 0) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}