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
    private int solve(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }

        int leftMin = 0;
        int rightMin = 0;

        if(root.left != null) {
            leftMin = solve(root.left);
        }

        if(root.right != null) {
            rightMin = solve(root.right);
        }

        return leftMin == 0 ? 1 + rightMin 
                : rightMin == 0 ? 1 + leftMin 
                : 1 + Math.min(leftMin, rightMin);
    }

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftMin = 0;
        int rightMin = 0;

        if(root.left != null) {
            leftMin = solve(root.left);
        }

        if(root.right != null) {
            rightMin = solve(root.right);
        }

        return leftMin == 0 ? 1 + rightMin 
                : rightMin == 0 ? 1 + leftMin 
                : 1 + Math.min(leftMin, rightMin);
    }
}