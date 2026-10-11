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

    record Pair(TreeNode node, int level){}

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int d = 1;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root,1));
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            d= Math.max(d, p.level);
            if(p.node.left != null) stack.push(new Pair(p.node.left, p.level + 1));
            if(p.node.right != null) stack.push(new Pair(p.node.right, p.level + 1));
        }
        return d;
    }
}
