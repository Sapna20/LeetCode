class Solution {
    public int findDuplicate(int[] arr) {
        // 0->1->3->2->4->2

        int n = arr.length;
        int fast = 0;
        int slow = 0;
        while(true) {
            fast = arr[arr[fast]];
            slow = arr[slow];
            if(slow == fast) {
                break;
            }
        }

        fast = 0;

        while(fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }

        return fast;
    }
}