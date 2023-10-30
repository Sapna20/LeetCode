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
    
    void getLeaves(TreeNode root, List<Integer> ls) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            ls.add(root.val);
            return;
        }

        getLeaves(root.left, ls);
        getLeaves(root.right, ls);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    
        List<Integer> ls1 = new ArrayList<Integer> ();
        List<Integer> ls2 = new ArrayList<Integer> ();
        
        getLeaves(root1, ls1);
        getLeaves(root2, ls2);
        
        if(ls1.equals(ls2)) {
            return true;
        }
        return false;
    }
}