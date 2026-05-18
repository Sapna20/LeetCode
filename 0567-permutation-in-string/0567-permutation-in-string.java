class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n) 
            return false;

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(int i=0; i<m; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        }

        int j=0;
        int i=0;
        while(j < n) {
           
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0)+1);
            if (j-i+1 == m) {

                if(map1.equals(map2))
                    return true;
                if(map2.containsKey(s2.charAt(i))) {
                    int val = map2.get(s2.charAt(i));
                    if(val == 1) {
                        map2.remove(s2.charAt(i));
                    } else {
                        map2.put(s2.charAt(i), val-1);
                    }
                }
                i++;
            }
            j++;
        }

        return false;
    }
}