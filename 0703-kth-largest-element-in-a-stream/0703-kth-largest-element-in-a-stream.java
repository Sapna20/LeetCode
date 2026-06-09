class KthLargest {

    Integer k;
    Queue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int x : nums) {
            if(this.k == pq.size()) {
                if(pq.peek() < x) {
                    pq.poll();
                    pq.offer(x);
                }
            } else {
                pq.offer(x);
            }
        }
    }
    
    public int add(int val) {
        if(this.k == pq.size()) {
            if(pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        } else {
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */