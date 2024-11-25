/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public int pairSum(ListNode head) {

        ListNode slowPtr = head, fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode rightPtr = reverse(slowPtr);
        ListNode leftPtr = head;

        int ans = 0;
        while(rightPtr != null) {
            ans = Math.max(ans, rightPtr.val + leftPtr.val);
            rightPtr = rightPtr.next;
            leftPtr = leftPtr.next;
        }

        return ans;
    }
}