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
    List<Integer> preorder;
    public void flatten(TreeNode root) {
        if (root == null) return;
        preorder = new ArrayList<>();
        helper(root);
        root.left = null;
        root.right = null;
        TreeNode node = root;
        for (int i = 1; i < preorder.size(); i++) {
            node.right = new TreeNode(preorder.get(i));
            node = node.right;
        }
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        preorder.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
