class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Node nahi mila
        if (root == null) {
            return null;
        }

        // Key chhoti hai → LEFT
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Key badi hai → RIGHT
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node mil gaya
        else {

            // 0 child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Sirf RIGHT child
            if (root.left == null) {
                return root.right;
            }

            // Sirf LEFT child
            if (root.right == null) {
                return root.left;
            }

            // 2 children
            TreeNode predecessor = root.left;

            // Left subtree ka sabse bada element
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }

            // Value copy
            root.val = predecessor.val;

            // Duplicate predecessor ko delete karo
            root.left = deleteNode(root.left, predecessor.val);
        }

        return root;
    }
}