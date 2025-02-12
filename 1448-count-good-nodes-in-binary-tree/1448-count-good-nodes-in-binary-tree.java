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

    private int solve(TreeNode root, int currMax) {
        if(root == null) {
            return 0;
        }

        if(root.val >= currMax) {
            return 1 + solve(root.left, root.val) + solve(root.right, root.val);
        } else {
            return solve(root.left, currMax) + solve(root.right, currMax);
        }
    }

    public int goodNodes(TreeNode root) {
        return 1 + solve(root.left, root.val) + solve(root.right, root.val);
    }
}