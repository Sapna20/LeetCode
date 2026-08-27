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

    private int idx = 0;

    private int inorderKthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }

        int a = inorderKthSmallest(root.left, k);
        idx = idx+1;
        // System.out.println(idx + " root=" + root.val);
        if(idx == k) {
            return root.val;
        }
        int b = inorderKthSmallest(root.right, k);

        return a == -1 ? b : a;
    }

    public int kthSmallest(TreeNode root, int k) {

        return inorderKthSmallest(root, k);
    }
}