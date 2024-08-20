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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode newNode = q.remove();
                
                if(newNode.left != null) q.add(newNode.left);
                if(newNode.right != null) q.add(newNode.right);
                
                lvl.add(newNode.val);
            }
            if(level % 2 == 0) {
                ans.add(lvl);
            }
            else ans.add(lvl.reversed());
            level++;
        }
        return ans;
        
    }
}