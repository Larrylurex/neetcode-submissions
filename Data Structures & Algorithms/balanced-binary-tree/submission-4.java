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
     public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[]{true};
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode node, boolean[] res) {
        if(node == null) return 0;
        // if(!res[0]) return -1;

        int left = dfs(node.left, res);
        if(!res[0]) return -1;
        int right = dfs(node.right, res);
        if(!res[0]) return -1;

        res[0] = Math.abs(left - right) <= 1;
        return 1 + Math.max(left, right);
    }
}
