class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    String getValue() {
        return value;
    }

    int getTimestamp() {
        return timestamp;
    }
}

class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<String, List<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Pair(value, timestamp));
        } else {
            map.put(key, new ArrayList<Pair>());
            map.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        return map.containsKey(key) ? binarySearch(map.get(key), timestamp) : "";
    }

    private String binarySearch(List<Pair> values, int targetTime) {
        int start = 0;
        int end = values.size()-1;

        while(start <= end) {
            int mid = (end-start)/2 + start;
            int time = values.get(mid).getTimestamp();
            if(time == targetTime) {
                return values.get(mid).getValue();
            } else if(time < targetTime) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return end >= 0 ? values.get(end).getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */