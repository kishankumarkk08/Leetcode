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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList <Integer> res = new ArrayList<>();
        int ans = 0;
        inOrder(root, res);
        for(int i = 0; i < res.size(); i++) {
            if(i == k-1) {
                ans = res.get(i);
            }
        }
        return ans;
    }
    public void inOrder(TreeNode root, ArrayList <Integer> res) {
        if(root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}