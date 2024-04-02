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

    private int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + count(root.right) + count(root.left);
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return root.val + sum(root.right) + sum(root.left);
    }

    public int averageOfSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            if(temp.val == sum(temp)/count(temp)) {
                ans += 1;
            }
            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
        }
        return ans;
    }
}