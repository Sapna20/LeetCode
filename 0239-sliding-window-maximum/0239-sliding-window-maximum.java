class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int i=0, j=0, n=nums.length;
        List<Integer> ls = new ArrayList<>();

        while(j<n) {
            while(!deq.isEmpty() && deq.peekLast() < nums[j]) {
                deq.pollLast();
            }
            deq.offerLast(nums[j]);

            if(j-i+1 == k) {
                ls.add(deq.peekFirst());
                if(nums[i] == deq.peekFirst()) {
                    deq.pollFirst();
                }
                i++;
            }
            j++;
        }

        int[] ans = new int[ls.size()];

        for(int idx=0; idx<ls.size(); idx++) {
            ans[idx] = ls.get(idx);
        }

        return ans;
    }
}