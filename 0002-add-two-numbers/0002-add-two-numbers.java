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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        ListNode sumList = l3;
        int pc = 0;

        while(l1 != null || l2 != null || pc != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int num = (a + b + pc) % 10;
            pc =  (a + b + pc) / 10;
        
            ListNode temp = new ListNode(num);
            l3.next = temp;
            l3 = l3.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return sumList.next;
    }
}