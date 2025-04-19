class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = edges.length;
        
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int un = map.getOrDefault(u, 0)+1;
            int vn = map.getOrDefault(v, 0)+1;
            map.put(u, un);
            map.put(v, vn);
            if(un == n)
                return u;
            else if(vn == n)
                return v;
        }
        
        return -1;
    }
}