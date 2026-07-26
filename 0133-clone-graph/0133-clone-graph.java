/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        } 
        ArrayList<Node> copyNbrs = new ArrayList<Node>();
        Node copyNode = new Node(node.val, copyNbrs);
        map.put(node, copyNode);

        for(Node nbr : node.neighbors) {
            Node cnbr = cloneGraph(nbr);
            copyNbrs.add(cnbr);
        }

        return copyNode;
    }
}