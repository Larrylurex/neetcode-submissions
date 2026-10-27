/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> cloned = new HashMap();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        cloned.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node nb : n.neighbors) {
                if (!cloned.containsKey(nb)) {
                    cloned.put(nb, new Node(nb.val));
                    queue.offer(nb);
                }
                cloned.get(n).neighbors.add(cloned.get(nb));
            }
        }
        return cloned.get(node);
    }
}