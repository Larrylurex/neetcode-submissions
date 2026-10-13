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
    public int goodNodes(TreeNode root) {
        int[] goodNodes = new int[]{0};

        isGood(root, Integer.MIN_VALUE, goodNodes);
        return goodNodes[0];
    }

    private void isGood(TreeNode node, int max, int[] goodNodes) {
        if(node == null) return;

        if(node.val >= max) {
            goodNodes[0]++;
        }
        isGood(node.left, Math.max(max, node.val), goodNodes);
        isGood(node.right, Math.max(max, node.val), goodNodes);

    }

}
