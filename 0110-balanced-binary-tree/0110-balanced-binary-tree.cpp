/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    bool balanced = true;
    int bserach(TreeNode* root)
    {
        if(!root)
        {
            return 0;
        }
        int lh = bserach(root->left);
        int rh = bserach(root->right);

        if(balanced && abs(lh - rh) > 1)
        {
            balanced = false;
        }
        return max(lh , rh) + 1;
    }
public:
    bool isBalanced(TreeNode* root) {
        bserach(root);
        return balanced;
    }
};