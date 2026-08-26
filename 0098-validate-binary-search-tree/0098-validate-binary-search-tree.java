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

    private boolean isValid(TreeNode root, long leftBound, long rightBound) {
        if(root == null)
            return true;

        return root.val > leftBound 
            && root.val < rightBound 
            && isValid(root.left, leftBound, root.val) 
            && isValid(root.right, root.val, rightBound);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}