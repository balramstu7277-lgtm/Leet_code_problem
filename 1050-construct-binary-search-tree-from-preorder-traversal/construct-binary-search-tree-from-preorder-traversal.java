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
    public TreeNode InsertIntoBst(TreeNode root , int num ){
        if(root == null) return new TreeNode(num);
        if( root.val > num){
            // insert into left subtree 
           if(root.left == null) root.left = new TreeNode(num);
           else InsertIntoBst(root.left , num);
        }
        else{
            // insert into right subtree 
            if(root.right == null) root.right = new TreeNode(num);
           else InsertIntoBst(root.right , num);
        }
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length;i++){
            root = InsertIntoBst(root, preorder[i]);
        }
        return root;
        
    }
}