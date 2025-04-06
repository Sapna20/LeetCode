class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<Pair> ls = map.get(key);
            ls.add(new Pair(value, timestamp));
            map.put(key, ls);
        } else {
            List<Pair> ls = new ArrayList<Pair>();
            ls.add(new Pair(value, timestamp));
            map.put(key, ls);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> ls = map.getOrDefault(key, new ArrayList<>());
        if(ls.size() == 0)
            return "";
        
        int n = ls.size();
        int end = n-1;
        int start = 0;

        while(start <= end) {
            int mid = start + (end - start)/2;
            Pair mp = ls.get(mid);
            String mv = mp.value;
            int mt = mp.timestamp;

            if(timestamp == mt) {
                return mv;
            } else if(timestamp > mt) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return end != -1 ? ls.get(end).value : "";
    }
}

class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }


}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */