class Solution {

    private boolean isSubMap(Map<Character, Integer> tmap, Map<Character, Integer> smap) {
        for(Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(!smap.containsKey(key) || smap.get(key) < value) {
                return false;
            } 
        }
       
        return true;
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        String ans = "";

        if(n > m) {
            return ans;
        }

        int i=0, j=0;
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        for(i=0; i<t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);
        }

        i=0;
        while(j < m) { // ABC
            if(!tmap.containsKey(s.charAt(j))) {
                j++;
                continue;
            }

            smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 0)+1);
            j++;
            if(isSubMap(tmap, smap)) {
                while(!tmap.containsKey(s.charAt(i)) || tmap.get(s.charAt(i)) < smap.get(s.charAt(i))) {
                    
                    if(!smap.containsKey(s.charAt(i)))  {
                        i++;
                        continue;
                    }
                    smap.put(s.charAt(i), smap.get(s.charAt(i))-1);
                    i++;
                }
                if(ans.length() == 0 || ans.length() > s.substring(i, j).length()) {
                    ans = s.substring(i, j);
                }
            }
        }
        return ans;
    }
}