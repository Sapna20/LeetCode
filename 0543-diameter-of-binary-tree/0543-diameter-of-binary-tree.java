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

    HashMap<TreeNode, Integer> hMap = new HashMap<TreeNode, Integer>();

    private int heightOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(hMap.containsKey(root)) {
            return hMap.get(root);
        }

        int height = 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));

        hMap.put(root, height);

        return height;
        
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