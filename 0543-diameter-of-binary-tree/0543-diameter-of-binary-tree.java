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

    private HashMap<TreeNode, Integer> map = new HashMap<>();
    private HashMap<TreeNode, Integer> dmap = new HashMap<>();

    private int dia(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(!this.map.containsKey(root)) {
            map.put(root, 1 + Math.max(dia(root.left), dia(root.right)));
        }

        return map.get(root);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ) {
            return 0;
        }

        int rootDia = dia(root.left) + dia(root.right);

        if(!dmap.containsKey(root)) {
            dmap.put(root, 
                        Math.max(rootDia, 
                            Math.max(diameterOfBinaryTree(root.left),
                                    diameterOfBinaryTree(root.right))
                            )
                    );
        }

        return dmap.get(root);

    }
}