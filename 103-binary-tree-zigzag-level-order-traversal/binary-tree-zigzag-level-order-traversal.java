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
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void zigzag1(TreeNode root, int n, List<Integer> arr) {
        if (root == null)
            return;
        if(n == 1) {
            arr.add(root.val);
            return;
        }
        zigzag1(root.left, n - 1, arr);
        zigzag1(root.right, n - 1, arr);
    }

    public void zigzag2(TreeNode root, int n, List<Integer> arr) {
        if (root == null)
            return;
        if(n == 1) {
            arr.add(root.val);
        }
        zigzag2(root.right, n - 1, arr);
        zigzag2(root.left, n - 1, arr);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = height(root) + 1;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        for (int i = 1; i < level; i++) {
            List<Integer> arr = new ArrayList<>();
            if (i % 2 == 1)
                zigzag1(root, i, arr);
            else
                zigzag2(root, i, arr);
            ans.add(arr);
        }
        return ans;
    }
}