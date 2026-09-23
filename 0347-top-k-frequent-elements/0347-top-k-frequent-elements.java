class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( 
                                        (x, y) -> x[1] - y[1] 
                                    );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(pq.size() == k) {
                if(entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                } else {
                    continue;
                }
            }
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++) {
            int[] e = pq.poll();
            ans[i] = e[0];
        }

        return ans;
    }
}