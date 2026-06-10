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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // Edge case
        if (root == null)   return ans;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int totalNodesAtCurrHeight = queue.size();
            ArrayList<Integer> currHeight = new ArrayList<>();
            // Iterate through each node at current height
            for (int i = totalNodesAtCurrHeight; i > 0; i--) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }

                currHeight.add(currNode.val);
            }
            ans.add(currHeight);
        }

        return ans;
    }
}
