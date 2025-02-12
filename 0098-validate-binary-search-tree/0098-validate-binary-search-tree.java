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


    long currNum = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        boolean left = isValidBST(root.left);
        if(root.val <= currNum)
            return false;
        currNum = root.val;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}