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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList <Integer> res = new ArrayList<>();
        inOrder(root, res);
        return build(res, 0 , res.size() - 1);
    }
    public void inOrder(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right,res);
    }
    public TreeNode build(ArrayList<Integer> res, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = build(res, start, mid - 1);
        root.right = build(res,mid+1,end);
        return root;

    }
}