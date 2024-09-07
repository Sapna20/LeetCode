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

    private int dia(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(dia(root.left), dia(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ) {
            return 0;
        }

        int rootDia = dia(root.left) + dia(root.right);

        return Math.max(rootDia, 
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right))
                    );

    }
}