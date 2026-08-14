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
    public int sum = 0;
    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
       return root; 
    }
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        return helper(root);
        
    }
}