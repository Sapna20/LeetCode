class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        if(k > n)
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int i;
        for(i=0; i<k; i++) {
            Character key1 = s1.charAt(i);
            Character key2 = s2.charAt(i);
            map1.put(key1, map1.getOrDefault(key1, 1) + 1);
            windowMap.put(key2, windowMap.getOrDefault(key2, 1) + 1);
        }

        while(i<n) {
            if(map1.equals(windowMap))
                return true;
            
            windowMap.remove(s2.charAt(i-k));
            windowMap.put(s2.charAt(i), windowMap.getOrDefault(s2.charAt(i), 1) + 1);
            i++;
        }


        return map1.equals(windowMap);
        
    }
}