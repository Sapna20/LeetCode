class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(key, ls);
            }
        }


        for(List<String> ls : map.values()) {
            ans.add(ls);
        }

        return ans;
    }
}