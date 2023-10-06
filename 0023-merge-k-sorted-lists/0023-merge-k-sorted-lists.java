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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        while(true) {
            int ind = -1;
            int t = Integer.MAX_VALUE;
            for(int j=0; j<lists.length; j++) {
                if(lists[j] != null && lists[j].val < t) {
                    ind = j;
                    t = lists[j].val;
                }
            }
            if(ind != -1) {
                dummy.next = lists[ind];
                lists[ind] = lists[ind].next;
                dummy= dummy.next;
            } else {
                break;
            }
        }

        return head.next;
    }
}