/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public int size(ListNode head) {
        int count = 0;

        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public TreeNode helper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int len = size(head);
        int[] arr = new int[len];
        if (head == null)
            return null;
        int index = 0;
        ListNode temp = head;
        while (temp != null) {
            arr[index] = temp.val;
            temp = temp.next;
            index++;
        }
        TreeNode result = helper(arr, 0, arr.length - 1);
        return result;
    }
}