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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        findPaths(root,"",result);
        return result;
    }

    private void findPaths(TreeNode node , String path , List<String> result)
    {
        path += node.val;
        if(node.left == null && node.right == null)
        {
            result.add(path);
        }
        else{
            path += "->";
            if(node.left != null)
            {
                findPaths(node.left , path, result);
            }
            if(node.right != null)
            {
                findPaths(node.right , path , result);
            }
        }
    }
}