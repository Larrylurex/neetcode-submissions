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
        Node c = head;
        while(c != null) {
            covered.put(c, new Node(c.val));
            c = c.next;
        }
        c = head;
        while(c != null) {
            Node cp = covered.get(c);
            cp.next = covered.get(c.next);
            cp.random = covered.get(c.random);
            c= c.next;
        }
        return covered.get(head);
    }

}
