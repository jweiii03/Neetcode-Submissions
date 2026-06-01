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
    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;

        return Math.max(helper(root.left, depth), helper(root.right, depth));
    }

    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
}
