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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode ptr = head;
        ListNode oddEnd = ptr;
        ListNode evenStart = ptr.next;
        int i = 0;

        while(ptr != null && ptr.next != null) {
            ListNode temp = ptr.next;
            ptr.next = ptr.next.next;
            ptr = temp;
            if(i%2 != 0) {
                oddEnd = ptr;
            }
            i++;
        }

        oddEnd.next = evenStart;

        return head;
    }
}