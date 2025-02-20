class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            int z = y-x;
            if(z!=0)
                pq.offer(z);

        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}