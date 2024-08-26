/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        longest(root);
        return max;
    }

    public int longest(TreeNode root) {
        if (root == null)
            return 0;
        int left = longest(root.left);
        int right = longest(root.right);
        int Lcount = 0, Rcount = 0;
        if (root.left != null && root.val == root.left.val) {
            Lcount = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            Rcount = right + 1;
        }
        int path = Lcount + Rcount;
        max = Math.max(max, path);
        return Math.max(Lcount, Rcount);

    }
}