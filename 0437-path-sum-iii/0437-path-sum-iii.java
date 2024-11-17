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
    private int ans = 0;
    private void path(TreeNode root ,  long sum)
    {
        if(root == null)
        {
            return;
        }
        if(root.val == sum)
        {
            ans++;
        }
        path(root.left , sum - root.val);
        path(root.right , sum - root.val);
    }
    public int pathSum(TreeNode root,  long targetSum) {
       if(root != null){
            path(root , targetSum);
            pathSum(root.left , targetSum);
            pathSum(root.right , targetSum);
       }
        return ans;
    }
} 