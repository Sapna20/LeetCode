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

    int idx;

    private TreeNode buildTreeProcess(int[] preorder, int[] inorder, int start, int end, int n) {
        if( idx >= n || start < 0 || end >= n || start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx]);

        int i = -1;
        for(i=start; i<=end; i++) {
            if(inorder[i] == preorder[idx]) {
                break;
            }
        }

        if(i==-1)
            return null;

        idx++;
        root.left = buildTreeProcess(preorder, inorder, start, i-1, n);
        root.right = buildTreeProcess(preorder, inorder, i+1, end, n);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        idx = 0;
        return buildTreeProcess(preorder, inorder, 0, n-1, n);
    }
}