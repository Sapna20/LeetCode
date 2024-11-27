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

    private boolean isIdentical(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) 
            return true;
        else if(tree1 == null || tree2 == null)
            return false;

        return tree1.val == tree2.val 
                && isIdentical(tree1.left, tree2.left)
                && isIdentical(tree1.right, tree2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null)
            return true;
        else if(root == null || subRoot == null)
            return false;

        return isIdentical(root, subRoot) 
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot); 
    }
}