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

    private int solve(TreeNode root, int sum) {
        if(root == null)
            return sum;


        sum = solve(root.right, sum);

        // System.out.println(sum + "--" + root.val);
        root.val += sum;

        sum = solve(root.left, root.val);

        return sum;
    }
    public TreeNode bstToGst(TreeNode root) {
        solve(root, 0);
        return root;
    }
}