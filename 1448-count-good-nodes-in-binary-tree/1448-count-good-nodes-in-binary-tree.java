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

    private int processGoodNodes(TreeNode root, int maxSoFar, int count) {
        if(root == null) 
            return count;

        if(root.val >= maxSoFar) {
            maxSoFar = root.val;
            count++;   
        }

        count = processGoodNodes(root.left, maxSoFar, count);
        count = processGoodNodes(root.right, maxSoFar, count);
        return count;
    }
    public int goodNodes(TreeNode root) {
        return processGoodNodes(root, Integer.MIN_VALUE, 0);
    }
}