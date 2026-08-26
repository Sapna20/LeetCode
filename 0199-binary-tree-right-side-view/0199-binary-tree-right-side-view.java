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

    List<Integer> list = new ArrayList<Integer>();

    private List<Integer> traverse(TreeNode root, int level) {
        if (root == null) {
            return list;
        }

        if(list.size() == level) {
            list.add(root.val);
        }

        traverse(root.right, level+1);
        traverse(root.left, level+1);

        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        return traverse(root, 0);
    }
}