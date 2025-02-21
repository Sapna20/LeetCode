class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if(k>=n)
            return points;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> { 
            int x1 = a.get(0);
            int y1 = a.get(1);

            int x2 = b.get(0);
            int y2 = b.get(1);

            return Integer.compare(x2*x2 + y2*y2, x1*x1 + y1*y1);
        });

        for(int i=0; i<n; i++) {
            List<Integer> ls = new ArrayList<Integer>();
            ls.add(points[i][0]);
            ls.add(points[i][1]);
            pq.offer(ls);
            if(pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()) {
            ans[i][0] = pq.peek().get(0);
            ans[i][1] = pq.peek().get(1);
            i++;
            pq.poll();
        }

        return ans;
    }
}