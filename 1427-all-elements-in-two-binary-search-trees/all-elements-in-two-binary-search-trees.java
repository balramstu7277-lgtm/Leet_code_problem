class Solution {
    public List<Integer> inorder(TreeNode root, List<Integer> ans) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // find pred 
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;

                }
                if (pred.right == curr) {
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            } else {
                ans.add(curr.val);
                curr = curr.right;

            }
        }
        return ans;
    }

    public void merge(List<Integer> list1, List<Integer> list2, List<Integer> ans) {
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }
        if (i == list1.size()) {
            while (j < list2.size()) {
                ans.add(list2.get(j));
                j++;
            }
        }
        if (j == list2.size()) {
            while (i < list1.size()) {
                ans.add(list1.get(i));
                i++;
            }
        }

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        inorder(root1, ans1);
        inorder(root2, ans2);
        merge(ans1, ans2, ans);
        return ans;
    }
}