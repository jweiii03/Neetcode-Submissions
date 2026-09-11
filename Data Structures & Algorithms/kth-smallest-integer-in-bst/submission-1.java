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
    int kthSmallestNum = 0;
    int count = 1;

    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        if (count == k) {
            kthSmallestNum = root.val;
        }
        count++;

        helper(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Inorder traversal in BST = Sorted order
        helper(root, k);
        return kthSmallestNum;
    }
}
