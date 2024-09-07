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
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    private boolean helper(TreeNode p1, TreeNode p2) {
        if(p1 == null && p2 == null) {
            return true;
        }
        if(p1 == null || p2 == null) {
            return false;
        }
        return helper(p1.left, p2.right) && helper(p1.right, p2.left) && (p1.val == p2.val);
    }
}