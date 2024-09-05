class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftSub = maxDepth(node.left);
        int rightSub = maxDepth(node.right);
        if (Math.abs(leftSub - rightSub) > 1) {
            isBalanced = false;
        }
        return Math.max(leftSub, rightSub) + 1;
    }
}