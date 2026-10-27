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
        if(node == null) return null;
        Map<Node, Node> cloned = new HashMap();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node clonedNode = cloned.get(n);
            if (clonedNode == null) {
                clonedNode = new Node(n.val, new ArrayList<>());
                cloned.put(n, clonedNode);
            }
            for (Node neighbour : n.neighbors) {
                Node clonedNeighbour = cloned.get(neighbour);

                if (clonedNeighbour == null) {
                    queue.offer(neighbour);

                    clonedNeighbour = new Node(neighbour.val, new ArrayList<>());
                    cloned.put(neighbour, clonedNeighbour);
                }
                clonedNode.neighbors.add(clonedNeighbour);
            }
        }
        return cloned.get(node);
    }
}