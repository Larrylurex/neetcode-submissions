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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.val == subRoot.val && checkSubTree(node, subRoot)) return true;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return false;
    }

    record Pair(TreeNode root, TreeNode subRoot){}

    boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, subRoot));

        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode subNode = p.subRoot;
            TreeNode node = p.root;

            if(subNode == null && node == null) continue;

            int subNodeLeftVal = subNode.left == null ? Integer.MAX_VALUE : subNode.left.val;
            int nodeLeftVal = node.left == null ? Integer.MAX_VALUE : node.left.val;
           
            if(subNodeLeftVal != nodeLeftVal) return false;
            
            stack.push(new Pair(node.left, subNode.left));
            

            int subNodeRightVal = subNode.right == null ? Integer.MAX_VALUE : subNode.right.val;
            int nodeRightVal = node.right == null ? Integer.MAX_VALUE : node.right.val;
           
            if(subNodeRightVal != nodeRightVal) return false;
            
            stack.push(new Pair(node.right, subNode.right));
        }
        return true;
    }

}
