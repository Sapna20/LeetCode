class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int curr_sum = 0;
        int i=0, j=0, n = nums.length;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] ans = new int[n-k+1];

        for(j=0; j<k; j++) { // 1R, 3, 1 
            while(dq.peekLast() != null && nums[j] > nums[dq.peekLast()]) { //3 > 1
                dq.pollLast(); // 1R, 
            }
            dq.offerLast(j); //  
        } 

        // 3, 3, 5, 
        for(j=k; j<n; j++) { // 1R, 3, 1 
            ans[j-k] = nums[dq.peekFirst()];
            if(dq.peekFirst() <= i) {
                dq.pollFirst();
            }
            i++;
            while(dq.peekLast() != null && nums[j] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(j);
        }

        ans[n - k] = nums[dq.peekFirst()];

        return ans;
    }
}