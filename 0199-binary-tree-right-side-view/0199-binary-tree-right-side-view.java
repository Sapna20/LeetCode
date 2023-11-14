/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private List<Integer> getView(TreeNode root, List<Integer> ls, int level) {
        if(root == null) {
            return ls;
        }

        if(ls.size() < level) {
            ls.add(root.val);
        }

        ls = getView(root.right, ls, level+1);
        ls = getView(root.left, ls, level+1);

        return ls;
        
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root == null) {
            return ls;
        }

        return getView(root, ls, 1);
    }
}