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
    record Triple(TreeNode node, int min, int max){}

    public boolean isValidBST(TreeNode root) {
        Deque<Triple> stack = new ArrayDeque<>();
        stack.push(new Triple(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!stack.isEmpty()) {
            Triple triple = stack.pop();
            if(triple.node == null) continue;

            if(!(triple.node.val > triple.min && triple.node.val < triple.max )) return false;
            stack.push(new Triple(triple.node.left, triple.min, triple.node.val));
            stack.push(new Triple(triple.node.right, triple.node.val, triple.max));
        } 
        return true;     
    }

}
