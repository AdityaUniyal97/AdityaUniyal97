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
    int d = 0;
    private int h(TreeNode root){
        if(root == null)
        {
            return 0;
        }
        int lh = h(root.left);
        int rh = h(root.right);
        int curr = (lh + rh);
        d = Math.max(d , curr);
        return Math.max(lh , rh) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        h(root);
        return d;
    }
}