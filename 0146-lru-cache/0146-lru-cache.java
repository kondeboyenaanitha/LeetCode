class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;

    static class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        pushToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            pushToHead(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }

    private void pushToHead(Node node) {
        remove(node);
        add(node);
    }

    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}