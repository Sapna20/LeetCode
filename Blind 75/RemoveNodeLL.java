// Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
        
        ListNode ptr = head;
        ListNode ptr2 = head;
        
        //move fast ptr for offset
        for(int i=0; i<n; i++) {
            ptr = ptr.next;
        }

        //first node to be removed
        if(ptr == null) {
            return head.next;
        }

        //move slow ptr
        while(ptr.next != null) {
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }

        //remove node
        ptr2.next = ptr2.next.next;

        return head;

    }
}
