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
        if(root == null) 
            return ans;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(null);

        while(q.size() > 1) {
            List<Integer> ls = new ArrayList<Integer>();
            while(q.peek() != null) {
                TreeNode temp = q.poll();
                ls.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)  
                    q.add(temp.right);
            }
            q.add(null);
            q.poll();
            ans.add(ls);
        }
        return ans;
    }
}