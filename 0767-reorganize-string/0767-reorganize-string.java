class Pair<T, U> {
    T key;
    U value;

    Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    T getKey() {
        return this.key;
    }

    void setKey(T key) {
        this.key = key;
    }

    U getValue() {
        return this.value;
    }

    void setValue(U value) {
        this.value = value;
    }

}

class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                int curr = map.get(c);
                map.put(c, curr+1);
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            Pair<Character, Integer> p = new Pair<>(e.getKey(), e.getValue());
            pq.offer(p);
        }

        String ans = "";
        Pair<Character, Integer> prev = null;

        while(!pq.isEmpty()) {
            Pair<Character, Integer> p = pq.poll();
            ans += p.getKey();
            p.setValue(p.getValue()-1);
            if(prev != null)
                pq.offer(prev);

            if(p.getValue() != 0)
                prev = p;
            else 
                prev = null;
        }

        if(prev != null) {
            return "";
        }
        return ans;

    }
}