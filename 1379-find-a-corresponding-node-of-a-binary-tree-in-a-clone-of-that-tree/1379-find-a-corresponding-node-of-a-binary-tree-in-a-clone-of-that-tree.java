/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target) {
            return cloned;
        }

        TreeNode tempLeft = null;
        TreeNode tempRight = null;
        if(original.left != null)
            tempLeft = getTargetCopy(original.left, cloned.left, target);

        if(original.right != null) 
            tempRight = getTargetCopy(original.right, cloned.right, target);

        return tempLeft == null ? tempRight : tempLeft;
    }
}