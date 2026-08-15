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
    TreeNode prev = null;
    int diff = 0;
    public int min = Integer.MAX_VALUE;

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        helper(root.left);
        if (prev != null) {
            diff = prev.val - root.val;
            if (diff < 0)
                diff = -diff;
            min = Math.min(diff, min);
        }
        prev = root;
        helper(root.right);
        return min;

    }

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root);
    }
}