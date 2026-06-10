class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();

        for(int x : nums) {
            if(pq.size() == k) {
                if(x > pq.peek()) {
                    pq.poll();
                    pq.offer(x);
                }
            } else {
                pq.offer(x);
            }
        }

        return pq.peek();
    }
}