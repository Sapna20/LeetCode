class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node() {};
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    HashMap<Integer, Node> map;
    int capacity, currCapacity;
    Node front, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        front = new Node();
        tail = new Node();
        front.next = tail;
        tail.prev = front;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
        
            if(capacity < map.size()) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            addToFront(node);
        }
    }

    private void addToFront(Node node) {
        Node temp = front.next;
        node.prev = front;
        front.next = node;
        node.next = temp;
        temp.prev = node;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */