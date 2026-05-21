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
    public void reorderList(ListNode head) {
        ListNode temp1 = head;
        int n = 0;
        while(temp1 != null) {
            n++;
            temp1 = temp1.next;
        }

        int half_n = (n+1)/2;
        
        ListNode temp2 = head;
        int first_half = 0;
        while(first_half != half_n) {
            temp2 = temp2.next;
            first_half++;
        }

        ListNode partList = reverseList(temp2);

        ListNode curr = head;
        ListNode upc = partList;

        while(curr != null) {
            ListNode temp3 = curr.next;
            curr.next = upc;
            upc = temp3;
            curr = curr.next;
        }
    }

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
}