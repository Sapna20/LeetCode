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

    private int countGoodNodes(TreeNode root, int max_so_far) {
        if(root == null) {
            return 0;
        }

        int count_curr = 0;
        if(root.val >= max_so_far) {
            count_curr++;
            max_so_far = root.val;
        }

        return count_curr + countGoodNodes(root.left, max_so_far) + countGoodNodes(root.right, max_so_far);
    }

    public int goodNodes(TreeNode root) {

        return countGoodNodes(root, Integer.MIN_VALUE);
        
    }
}