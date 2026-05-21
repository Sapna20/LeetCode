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

        if(head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node h1 = head;
        Node h2 = new Node(head.val);
        Node head2 = h2;
        map.put(h1, h2);

        h1 = h1.next;
        while(h1 != null) {
            Node temp = new Node(h1.val);
            h2.next = temp;
            h2 = h2.next;
            map.put(h1, h2);
            h1 = h1.next;
        }

        h1 = head;
        h2 = head2;

        while(h1 != null) {
            h2.random = map.get(h1.random);
            h2 = h2.next;
            h1 = h1.next;
        }

        return head2;
    
    }
}