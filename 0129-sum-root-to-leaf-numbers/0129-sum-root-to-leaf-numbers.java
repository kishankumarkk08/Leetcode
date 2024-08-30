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
    
    private int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        findSum(root, 0);
        return totalSum;
    }
    private void findSum(TreeNode root, int currNum){
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            totalSum += (currNum * 10 + root.val);
        }
        currNum = currNum * 10 + root.val;
        findSum(root.left, currNum);
        findSum(root.right, currNum);
    }
}
    
