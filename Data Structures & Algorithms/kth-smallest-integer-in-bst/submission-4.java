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
    public void helper(TreeNode root, int[] tmp) {
        if (root == null) {
            return;
        }
        helper(root.left, tmp);

        // The left subtree may have found the answer.
        if (tmp[0] == 0) {
            return;
        }

        tmp[0] -= 1;
        if (tmp[0] == 0) {
            tmp[1] = root.val;
            return;
        }
        
        helper(root.right, tmp);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Inorder traversal in BST = Sorted order
        int[] tmp = new int[2]; // Stores [currRank, kthSmallestNodeValue]
        tmp[0] = k;
        helper(root, tmp);
        return tmp[1];
    }
}
