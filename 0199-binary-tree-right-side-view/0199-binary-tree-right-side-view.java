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

    private void traversal(TreeNode root, int currLevel, List<Integer> rightMostNodes) {
        if(root == null)
            return;
        
        int newLevel = rightMostNodes.size();
        if(currLevel == newLevel) {
            rightMostNodes.add(root.val);
        }

        traversal(root.right, currLevel+1, rightMostNodes);
        traversal(root.left, currLevel+1, rightMostNodes);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        traversal(root, 0, ans);
        return ans;
    }
}