/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> covered = new HashMap<>();
        int nested = 0;
        return copy(head, covered, nested);
    }

    private Node copy(Node head, Map<Node, Node> covered, int nested) {
        Node copy = new Node(0);
        Node cCopy = copy;
        Node c = head;
        while(c != null) {
            Node n = covered.get(c);
            if(n != null) {
                cCopy.next = n;
                break;
            }
            cCopy.next = new Node(c.val); 
            covered.put(c, cCopy.next);

            if(c.random != null) {
                cCopy.next.random = copy(c.random, covered, nested + 1);
            }
            cCopy = cCopy.next;
            c = c.next;
        }
        return copy.next;
    }


}
