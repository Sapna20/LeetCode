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
        int i=0;
        ListNode temp = head;
        while(i != n) {
            temp = temp.next;
            i++;
        }

        if(temp == null) {
            return head == null ? null : head.next;
        }

        ListNode ptr = head;
        while(temp.next != null) {
            ptr = ptr.next;
            temp = temp.next;
        }

        ListNode temp2 = ptr.next;
        ptr.next = ptr.next.next;

        temp2.next = null;

        return head;
    }
}