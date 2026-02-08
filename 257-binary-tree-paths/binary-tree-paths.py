# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def binaryTreePaths(self, root):
        result = []
        self.dfs(root,"",result)
        return result
    
    def dfs(self,node,path,result):
        if node is None:
            return
        path = path + str(node.val)
        if node.left is None and node.right is None:
            result.append(path)
            return 
        self.dfs(node.left , path+"->",result)
        self.dfs(node.right, path+"->",result)
        