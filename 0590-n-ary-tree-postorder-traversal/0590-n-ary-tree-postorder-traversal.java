/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    List<Integer> ls = new ArrayList<Integer>();

    private void solve(Node root) {

        if(root == null) {
            return;
        }
        
        if(root.children.isEmpty()) {
            this.ls.add(root.val);
            return;
        }
        for(Node x : root.children) {
           postorder(x);
        }
        this.ls.add(root.val);
    }

    public List<Integer> postorder(Node root) {

        solve(root);
        return this.ls;
    }
}