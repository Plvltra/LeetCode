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
    
    // l:inclusive r:exclusive
    private static List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>(); 
        if(l == r){
            ans.add(null);
            return ans;
        }
        
        for(int pivot = l; pivot < r; pivot++){
            List<TreeNode> ltree = generateTrees(l, pivot);
            List<TreeNode> rtree = generateTrees(pivot+1, r);
            for(TreeNode lroot : ltree){
                for(TreeNode rroot : rtree){
                    TreeNode root = new TreeNode(pivot, lroot, rroot);
                    ans.add(root);
                }    
            }
        }
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1, n+1);
    }
}