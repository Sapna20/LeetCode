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

    private HashMap<TreeNode, Integer> map = new HashMap<>();

    private int heightOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        if(map.containsKey(root))
            return map.get(root);

        int height = 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));

        map.put(root, height);

        return height;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(
                heightOfBinaryTree(root.left)
                - heightOfBinaryTree(root.right)
            ) <= 1
            && isBalanced(root.left) 
            && isBalanced(root.right);
    }
}