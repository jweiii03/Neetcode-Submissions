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
// Time Complexity: O(n), every node is visited exactly once
// Space Complexity: O(height) or O(log(n)), worst case is skewed tree, where height = n

class Solution {
    public void helper(TreeNode root) {
        if (root == null)   return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        helper(root.left);
        helper(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
}
