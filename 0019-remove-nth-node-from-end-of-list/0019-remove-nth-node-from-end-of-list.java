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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }

        int i = 1;
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while(i != n ) {
            ptr1 = ptr1.next;
            i++;
        }

        ListNode prev = null;
        while(ptr1.next != null) {
            ptr1 = ptr1.next;
            prev = ptr2;
            ptr2 = ptr2.next;
        }

        if(prev == null) {
            return head.next;
        }

        prev.next = ptr2.next;

        return head;
    }
}