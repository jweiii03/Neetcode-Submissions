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
    int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Run DFS and it will automatically update maxDia since its a global variable
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        maxDia = Math.max(maxDia, left + right);
        // Heading back up tree, need to increment height as we climb back up tree
        return 1 + Math.max(left, right);
    }
}
