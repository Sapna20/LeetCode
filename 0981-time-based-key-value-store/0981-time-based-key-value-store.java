class Pair {
    String value;
    int timeStamp;

    Pair (String v, int t) {
        value = v;
        timeStamp = t;
    }
}

class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<String, List<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> ls = map.getOrDefault(key, new ArrayList<Pair>());
        ls.add(new Pair(value, timestamp));
        map.put(key, ls);
    }
    
    public String get(String key, int timestamp) {
        return map.containsKey(key) ? binarySearchValue(map.get(key), timestamp) : "";
    }

    private String binarySearchValue(List<Pair> ls, int timestamp) {
        int start = 0;
        int end = ls.size()-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(ls.get(mid).timeStamp == timestamp) {
                return ls.get(mid).value;
            } else if (ls.get(mid).timeStamp > timestamp) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return end < 0 ? "" : ls.get(end).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */