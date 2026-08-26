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

    Map<TreeNode, Integer> map = new HashMap<>();

    private int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        if(map.containsKey(node)) {
            return map.get(node);
        }

        int currH = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        map.put(node, currH);
        return currH;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}