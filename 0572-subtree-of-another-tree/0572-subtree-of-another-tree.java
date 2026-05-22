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

    private boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;

        return (root.val == subRoot.val) 
                                 && isIdentical(root.left, subRoot.left) 
                                 && isIdentical(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;
        
        boolean isMatched = isIdentical(root, subRoot);

        if(isMatched)
            return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}