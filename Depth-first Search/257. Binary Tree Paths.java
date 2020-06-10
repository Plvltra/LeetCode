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
    
    private List<String> paths;
    
    public List<String> binaryTreePaths(TreeNode root) {
        paths=new ArrayList<>();
        if(root == null){
            return paths;
        }
        
        dfs(root, new StringBuilder());
        return paths;
    }
    
    public void dfs(TreeNode root, StringBuilder prePath){
        if(root.left == null && root.right == null){
            paths.add(prePath.toString() + root.val);
            return;
        }
        
        int preEnd = prePath.length();
        prePath.append(root.val + "->");
        if(root.left != null)
            dfs(root.left, prePath);
        if(root.right != null)
            dfs(root.right, prePath);
        prePath.delete(preEnd, prePath.length());
    }   
}