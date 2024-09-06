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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List <List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) {
            return list;
        }

        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode newNode = q.remove();

                if(newNode.left != null) {
                    q.add(newNode.left);
                }
                if(newNode.right != null) {
                    q.add(newNode.right);
                }
                res.add(newNode.val);
            }
            list.add(res);
        }
        Collections.reverse(list);
        return list;

    }
}