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
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        int N=0, n=1;
        ListNode temp = head;
        while(temp != null) {
            N++;
            temp = temp.next;
        }
        if(N==1) 
            return;
        temp = head;
        while(n < N/2) {
            temp = temp.next;
            n++;
        }

        ListNode head2 = reverseList(temp.next);
        temp.next = null;
        ListNode head1 = head;
        ListNode dummy = new ListNode();
        int i=0;

        while(head1 != null && head2 != null) {
            if(i%2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            i++;
        }

        if(head1 == null) {
            dummy.next = head2;
        } else {
            dummy.next = head1;
        }
    }
}