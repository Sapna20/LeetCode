class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        String ans = "";

        for(int i=0; i<m; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i=0, j=0;

        while(j < n) {
            char rightChar = s.charAt(j);
            if(map.containsKey(rightChar)) {
                map2.put(rightChar, map2.getOrDefault(rightChar, 0)+1);
            }

            // System.out.println("j included = " + s.substring(i, j+1));

            while(isSubMap(map, map2)) {
                if(ans.length() == 0 || j-i+1 < ans.length()) {
                    ans = s.substring(i, j+1);
                }
                char leftChar = s.charAt(i);
                if(map2.containsKey(leftChar)) {
                    map2.put(leftChar, map2.get(leftChar)-1);
                }
                i++;
                // System.out.println("i excluded = " + s.substring(i, j+1));

            }
            j++;
        }

        return ans;
    }

    private boolean isSubMap(Map<Character, Integer> map, Map<Character, Integer> map2) {
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(map2.containsKey(entry.getKey()) 
                && map2.get(entry.getKey()) >= entry.getValue()) {
                    continue;
            } else {
                return false;
            }
        }
        return true;
    }
}