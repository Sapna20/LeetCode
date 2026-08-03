class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // TIME - O(N) SPACE - O(N)

        List<List<String>> ans = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {                      // O(N)
            char[] carr = str.toCharArray();
            Arrays.sort(carr);                      // O(100 log 100) -> O(1);
            String key = new String(carr);
            if(map.containsKey(key)) {
                map.get(key).add(str);             // O(1)
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(key, ls);                   // O(1)
            }
        }


        for(List<String> ls : map.values()) {    // O(N)
            ans.add(ls);
        }

        return ans;
    }
}