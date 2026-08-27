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

    private int maxSum;

    private int findMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftPathSum = Math.max(findMaxSum(root.left), 0);
        int rightPathSum = Math.max(findMaxSum(root.right), 0);

        maxSum = Math.max(maxSum, root.val + leftPathSum + rightPathSum);

        return Math.max(root.val + leftPathSum, root.val + rightPathSum);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return maxSum;
    }
}