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

    private void solve(TreeNode root, List<Integer> ls, int level) {
        if(root == null) {
            return;
        }

        if(level == ls.size()) {
            ls.add(root.val);
        }

        solve(root.right, ls, level+1);
        solve(root.left, ls, level+1);

        return;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        int level = 0;

        solve(root, ls, level);

        return ls;
    }
}