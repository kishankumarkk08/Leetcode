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
    static class Info {
        TreeNode node;
        int level;
        Info(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue <Info> q = new LinkedList<>();
        HashMap <Integer, TreeNode> map = new HashMap<>();
        int max = 0;
        
        q.add(new Info(root, 0));

        while(!q.isEmpty()) {
            Info currNode = q.remove();

            if(!map.containsKey(currNode.level)) {
                map.put(currNode.level, currNode.node);
            }
            if(currNode.node.right != null) {
                q.add(new Info(currNode.node.right, currNode.level + 1));
                max = Math.max(max, currNode.level + 1);
            }
            if(currNode.node.left != null) {
                q.add(new Info(currNode.node.left, currNode.level + 1));
                max = Math.max(max, currNode.level + 1);
            }
        }
        for(int i = 0; i <= max; i++) {
            res.add(map.get(i).val);
        }
        return res;
    }
}