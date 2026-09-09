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
    HashSet<TreeNode> pathForP = new HashSet<>();
    ArrayList<TreeNode> pathForQ = new ArrayList<>();

    public void findNode(TreeNode root, boolean forNodeP, TreeNode target) {
        if (root == null) {
            return;
        }

        if (forNodeP) {
            pathForP.add(root);
        } else {
            pathForQ.add(root);
        }

        if (root.val > target.val) {
            findNode(root.left, forNodeP, target);
        } else if (root.val < target.val) {
            findNode(root.right, forNodeP, target);
        } else {
            return;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, true, p);
        findNode(root, false, q);

        for (int i = pathForQ.size() - 1; i >= 0; i--) {
            if (pathForP.contains(pathForQ.get(i))) {
                return pathForQ.get(i);
            }
        }

        return null;
    }
}
