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
        ListNode temp = head;
        int N = 0;
        while( temp != null ){
            N++;
            temp = temp.next;
        }

        int k = N-n, i=1;
        temp = head;

        while(i<k) {
            temp = temp.next;
            i++;
        }

        if(k==0) {
            return head.next;
        }

        if(temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}