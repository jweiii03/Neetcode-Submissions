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
    public List<Integer> rightSideView(TreeNode root) {
        // Use a queue to maintain nodes on each height level
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // Edge case
        if (root == null)   return ans;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int totalNodesAtCurrHeight = queue.size();
            // Iterate through each node at current height
            for (int i = totalNodesAtCurrHeight; i > 0; i--) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                
                // Conditional check to see if Node is right most for that current level
                if (i == 1) {
                    ans.add(currNode.val);
                }
            }
        }

        return ans;
    }
}
