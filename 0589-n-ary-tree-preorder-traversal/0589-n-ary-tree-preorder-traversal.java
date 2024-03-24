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

    private void solve(Node root, List<Integer> ls) {
        if(root.children.isEmpty()) {
            ls.add(root.val);
            return;
        }
        ls.add(root.val);
        for(Node x : root.children) {
            solve(x, ls);
        }
    } 
    
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root == null) 
            return ls;

        solve(root, ls);
        return ls;
    }
}