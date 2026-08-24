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

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        ListNode l1 = head;
        ListNode l2 = reverseList(slowPtr);
        ListNode l3 = new ListNode();
        
        int i=0;
        while(l3 != null) {
            if(i%2 == 0) {
                l3.next = l1;
                l1 = l1 != null ? l1.next : null;
            } else {
                l3.next = l2;
                l2 = l2 != null ? l2.next : null;
            }
            l3 = l3.next;
            i++;
        }
    }
}