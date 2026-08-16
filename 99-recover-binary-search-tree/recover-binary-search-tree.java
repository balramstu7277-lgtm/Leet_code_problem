class Solution {
    public void recoverTree(TreeNode root) {

        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode prevPrev = null;

        List<TreeNode> ans = new ArrayList<>();

        while (curr != null) {

            if (curr.left != null) {

                // Find predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // First time: create thread
                if (pred.right == null) {

                    pred.right = curr;
                    curr = curr.left;
                }

                // Second time: remove thread and visit curr
                else {

                    pred.right = null;

                    // Check swapped node
                    if (prev != null && prevPrev != null) {

                        if (prev.val > curr.val &&
                            prev.val > prevPrev.val) {

                            ans.add(prev);
                        }

                        if (prev.val < curr.val &&
                            prev.val < prevPrev.val) {

                            ans.add(prev);
                        }
                    }
                    else if (prev != null) {

                        if (prev.val > curr.val) {
                            ans.add(prev);
                        }
                    }

                    prevPrev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }

            else {

                // Visit curr

                if (prev != null && prevPrev != null) {

                    if (prev.val > curr.val &&
                        prev.val > prevPrev.val) {

                        ans.add(prev);
                    }

                    if (prev.val < curr.val &&
                        prev.val < prevPrev.val) {

                        ans.add(prev);
                    }
                }
                else if (prev != null) {

                    if (prev.val > curr.val) {
                        ans.add(prev);
                    }
                }

                prevPrev = prev;
                prev = curr;
                curr = curr.right;
            }
        }

        // Check last node
        if (prev != null &&
            prevPrev != null &&
            prev.val < prevPrev.val) {

            ans.add(prev);
        }

        // Swap the two nodes
        TreeNode first = ans.get(0);
        TreeNode second = ans.get(ans.size()-1);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}