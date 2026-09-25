class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));

        for(int x : stones) {
            pq.add(x);
        }

        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            int z = Math.abs(x-y);

            if(z > 0) {
                pq.offer(z);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}