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
    // public void inorder(TreeNode root ,List<Integer> arr  ){
    //     if(root == null) return ;
    //     inorder(root.left , arr);
    //     arr.add(root.val);
    //     inorder(root.right, arr );
    // }
    int count;
    public int inorder(TreeNode root) {
        if (root == null) return -1;

        int left = inorder(root.left);

        if (left != -1) return left;

        count--;

        if (count == 0) {
            return root.val;
        }

        return inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
    //  List<Integer> arr = new ArrayList<>();
    count = k;
    return  inorder(root);
    
    // return arr.get(k-1);  
    }
}