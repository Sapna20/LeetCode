class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b-a));

        for(int x : stones) {
            pq.offer(x);
        } // nlogn

        while(pq.size() > 1) {
            int x = pq.poll(); // 1
            int y = pq.poll(); // 1
            int z = Math.abs(x - y);
            if(z != 0) {
                pq.offer(z); // log n
            }
        } // log n

        return pq.isEmpty() ? 0 : pq.peek();
    }
}