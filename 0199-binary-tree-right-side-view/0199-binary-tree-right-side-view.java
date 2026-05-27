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

    private List<Integer> ls = new ArrayList<Integer>();

    private void processRightSide(TreeNode root, int height) {
        if(root == null) 
            return;

        if(ls.size() == height) {
            ls.add(root.val);
        }

        processRightSide(root.right, height+1);
        processRightSide(root.left, height+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) 
            return ls;

        processRightSide(root, 0);
        return this.ls;
    }
}