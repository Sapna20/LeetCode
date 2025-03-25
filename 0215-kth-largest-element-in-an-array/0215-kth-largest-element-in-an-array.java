class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() == k+1)
                pq.poll(); 
        }

        return pq.peek();
    }
}