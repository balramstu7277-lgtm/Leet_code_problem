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
    TreeNode pred = null;

    public List<Integer> inorder(TreeNode root, List<Integer> ans) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                pred = curr.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = curr.left;
                curr = curr.left;
                pred = null;
                if (pred != null)
                    ans.add(pred.val);
                curr = curr.right;
            } else {
                if (pred != null) {
                    ans.add(pred.val);
                }
                curr = curr.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while (curr != null) {
            //find pred
            if (curr.left != null) {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    // connect pred to curr
                    pred.right = curr;
                    curr = curr.left;

                }
                if (pred.right == curr) {
                    // unlink pred  and currr
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }else{
                // curr.left == null , no pred 
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans ;

    }
}