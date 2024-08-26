/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap();
        Node ptr = head;
        Node ptr2 = null;
        Node head2 = null;

        if(ptr != null) {
            Node node = new Node(ptr.val);
            ptr2 = node;
            head2 = node;
            map.put(ptr, node);
            ptr = ptr.next;
        }

        while(ptr != null) {
            Node node = new Node(ptr.val);
            ptr2.next = node;
            map.put(ptr, node);
            ptr2 = ptr2.next;
            ptr = ptr.next;
        }

        // ptr = head;
        // ptr2 = head2;

        // while(ptr != null && ptr2 != null) {
        //     System.out.print(" " + ptr.val + " " + ptr2.val + " " + map.get(ptr).val);
        //     ptr = ptr.next;
        //     ptr2 = ptr2.next;
        // }

        ptr = head;

        while(ptr != null) {
            
           map.get(ptr).random = map.get(ptr.random);
            
            ptr = ptr.next;

        }

        return head2;
    }
}