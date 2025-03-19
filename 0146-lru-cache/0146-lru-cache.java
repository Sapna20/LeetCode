class LRUCache {

    int capacity;
    int curr;
    HashMap<Integer, Integer> map;
    Queue<Integer> q;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curr = 0;
        this.map = new HashMap<Integer, Integer>();
        this.q = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)) {
            this.q.remove(key);
            this.q.add(key);
            // System.out.println("get" + key + " " + this.q + this.map);
            return this.map.get(key);
        } else 
            return -1;
    }
    
    public void put(int key, int value) {
        if(this.curr < this.capacity ) {
            if(!this.map.containsKey(key)) {
                this.map.put(key, value);
                this.q.add(key);
                this.curr++;
                // System.out.println("put1 " + key + " " + this.q + this.map);
            } else {
                this.q.remove(key);
                this.q.add(key);
                this.map.put(key, value);
                // System.out.println("put2 " + key + " " + this.q + this.map);
            }

        } else {
            if(this.map.containsKey(key)) {
                this.q.remove(key);
                this.q.add(key);
                this.map.put(key, value);
                // System.out.println("put3 " + key + " " + this.q + this.map);                
            } else {
                int k = this.q.peek();
                this.map.remove(k);
                this.q.remove(k);
                this.map.put(key, value);
                this.q.add(key);
                // System.out.println("put4 " + key + " " + this.q + this.map);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */