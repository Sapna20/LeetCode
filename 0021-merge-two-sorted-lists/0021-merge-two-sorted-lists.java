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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr = new ListNode();
        ListNode l3 = ptr;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }

            ptr = ptr.next;
        }

        if(l1 == null && l2 != null) {
            ptr.next = l2;
        }

        if(l2 == null && l1 != null) {
            ptr.next = l1;
        }

        return l3.next;
    }
}