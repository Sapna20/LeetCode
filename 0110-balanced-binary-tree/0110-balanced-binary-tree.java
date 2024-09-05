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

    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int hL = getHeight(root.left);
        int hR = getHeight(root.right);

        return Math.abs(hL - hR) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
}