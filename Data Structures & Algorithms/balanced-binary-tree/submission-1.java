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

// Time complexity: O(n)
// Space complexity: O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    // int[] -> [isBalanced, height]
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Check if the left and right subtree is balanced
        boolean isBalanced = (left[0] == 1 && right[0] == 1) &&
                             (Math.abs(left[1] - right[1]) <= 1);
        
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{isBalanced ? 1 : 0, height};
    }
}
