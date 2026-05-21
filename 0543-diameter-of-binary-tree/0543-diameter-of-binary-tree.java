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

    private int heightOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
        
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int hl = heightOfBinaryTree(root.left);
        int hr = heightOfBinaryTree(root.right);

        int dia = hl + hr;

        return Math.max(dia, 
                        Math.max(
                            diameterOfBinaryTree(root.left),
                            diameterOfBinaryTree(root.right)
                            )
                        );
    }
}