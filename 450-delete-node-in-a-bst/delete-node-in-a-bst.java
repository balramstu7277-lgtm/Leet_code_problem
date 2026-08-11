class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // Go left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Go right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Only right child
            if (root.left == null) {
                return root.right;
            }

            // Only left child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            TreeNode predecessor = root.left;

            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }

            root.val = predecessor.val;

            root.left = deleteNode(root.left, predecessor.val);
        }

        return root;
    }
}