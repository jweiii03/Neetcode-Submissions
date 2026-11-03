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
    int kthSmallestNum;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = 0; // Reset in case the same Solution object is reused
        helper(root, k);
        return kthSmallestNum;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        helper(root.left, k);

        // The answer may have been found in the left subtree
        if (count >= k) {
            return;
        }

        count++;

        if (count == k) {
            kthSmallestNum = root.val;
            return;
        }

        helper(root.right, k);
    }
}
