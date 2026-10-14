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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode node, int[] res) {
        if(node == null) return 0;

        int left = Math.max(0, dfs(node.left, res));
        int right = Math.max(0, dfs(node.right, res));

        int sum =  node.val + left + right;
        res[0] = Math.max(res[0], sum);
        return node.val + Math.max(left, right);
    }
}
