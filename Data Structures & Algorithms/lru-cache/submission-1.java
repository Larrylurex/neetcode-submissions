class LRUCache {

    static class ListNode {

        int val;
        int key;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    HashMap<Integer, ListNode> map = new HashMap<>();

    ListNode head;
    ListNode tail;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;

    }

    // head (prev: null. next: tail) -> tail(0,0 prev: head, next: null)
    // head(prev: null. next: A) -> A(key, val, prev: head, next: tail ) tail(0,0 prev: A, next: null)
    void insert(ListNode node) {
        ListNode prev = tail.prev; // head (prev: null. next: tail)
        tail.prev = node; // tail(prev: A, next: null)
        node.next = tail; // A(key, val, prev: null , next: tail )
        node.prev = prev; // A(key, val, prev: head , next: tail )
        prev.next = node; // head (prev: null. next: A)
    }

    // head(prev: null. next: A) -> A(key, val, prev: head, next: tail ) tail(0,0 prev: A, next: null)
    // head (prev: null. next: tail) -> tail(0,0 prev: head, next: null)
    void remove(ListNode node) {
        ListNode prev = node.prev; // head(prev: null. next: A)
        ListNode next = node.next; // tail(0,0 prev: A, next: null)
        prev.next = next; // head(prev: null. next: tail)
        next.prev = prev;  // tail(0,0 prev: head, next: null)
    }

    // head(0,0) A(prev: null, next: B) -> B(prev: A, next: null) tail(0,0)
    // head: A, tail: B
    // get(A)
    // A(prev: B, next: null)  B(prev: A, next: A)
    public int get(int key) {
        ListNode node = map.get(key);
        if(node != null) {
            if(tail.prev != node) {
                remove(node);
                insert(node);
            }
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        var prevNode = map.put(key, newNode);
        if(prevNode != null) {
            remove(prevNode);
        }
        insert(newNode);

        if(map.size() > capacity) {
            map.remove(head.next.key);
            remove(head.next);
        }
    }
}
