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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return ans;
        q.add(root);

        while(!q.isEmpty()) {
            q.add(null);
            List<Integer> ls = new ArrayList<Integer>();
            TreeNode node = q.poll();
            while(node != null) {
                ls.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null) 
                    q.offer(node.right);
                node = q.poll();
            }
            ans.add(ls);
        }

        return ans;
    }
}