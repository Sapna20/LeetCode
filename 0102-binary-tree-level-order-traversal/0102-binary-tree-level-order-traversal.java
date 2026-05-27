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
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        que.add(root);

        while(!que.isEmpty()) {
            que.add(null);
            List<Integer> ls = new ArrayList<Integer>();
            while(que.peek() != null) {
                TreeNode node = que.poll();
                ls.add(node.val);
                if(node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null) {
                    que.offer(node.right);
                }
            }
            que.poll();
            ans.add(ls);
        }

        return ans;
    }
}