class Solution {

    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<int[]>((y , x) -> (x[0]*x[0] + x[1]*x[1]) - (y[0]*y[0] + y[1]*y[1]));

        for(int[] z : points) {
            if(pq.size() == k) {
                int[] temp = pq.peek();
                int flag = (temp[0]*temp[0] + temp[1]*temp[1]) - (z[0]*z[0] + z[1]*z[1]);

                if(flag > 0) {
                    pq.poll();
                    pq.offer(new int[]{z[0], z[1]});
                } 
            }  else {
                pq.offer(new int[]{z[0], z[1]});
            }
        }

        int[][] ans = new int[k][2];

        int i=0;
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            ans[i] = arr;
            i++;
        }

        return ans;
    }
}