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
        Map<Node, Node> nodeMap = new HashMap<>();

        Node original = head;
        Node copy = new Node(-1);
        Node copyHead = copy;

        while(original != null) {
            Node copyNode = new Node(original.val);
            nodeMap.put(original, copyNode);

            copy.next = copyNode;
            copy = copy.next;
            original = original.next;
        }

        original = head;
        copy = copyHead.next;

        while(original != null) {
            copy.random = nodeMap.get(original.random);
            original = original.next;
            copy = copy.next;
        }

        return copyHead.next;

    }
}