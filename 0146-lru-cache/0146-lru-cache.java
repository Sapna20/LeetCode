class Node {
    Node left;
    Node right;
    int val;
    int key;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node cacheRear;
    Node cacheFront;
    Map<Integer, Node> map;
    int capacity;
    int currSize;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        cacheRear = new Node(-1, -1);
        cacheFront = new Node(-1, -1);
        cacheRear.left = cacheFront;
        cacheFront.right = cacheRear;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cacheNode = map.get(key);
            removeFromCache(cacheNode);
            insertIntoCache(cacheNode);

            return cacheNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node cacheNode = map.get(key);
            cacheNode.val = value;
            removeFromCache(cacheNode); // helper method
            insertIntoCache(cacheNode); // helper method
            map.put(key, cacheNode);
        } else {
            if(currSize == capacity) {
                int keyToRemove = cacheFront.right.key;
                removeFromCache(cacheFront.right); // helper method
                map.remove(keyToRemove); 
                currSize--;
            }
            Node cacheNode = new Node(key, value);
            insertIntoCache(cacheNode); // helper method
            map.put(key, cacheNode);
            currSize++;
        }
    }

    void insertIntoCache(Node cacheNode) {
        Node prev = cacheRear.left;
        prev.right = cacheNode;
        cacheNode.left = prev;
        cacheRear.left = cacheNode;
        cacheNode.right = cacheRear;
    }

    void removeFromCache(Node cacheNode) {
        Node prev = cacheNode.left;
        Node next = cacheNode.right;

        if(prev != null) {
            prev.right = next;
        }
        if(next != null) {
            next.left = prev;
        }
        cacheNode.left = null;
        cacheNode.right = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */