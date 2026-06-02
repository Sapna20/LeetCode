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

    private int pos = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }


        int a = kthSmallest(root.left, k);
        this.pos++;
        if(this.pos == k) {
            return root.val;
        }
        
        int b = kthSmallest(root.right, k);

        return a == -1 ? b : a;
    }
}