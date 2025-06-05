class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> ans = new ArrayList<List<String>>();

        for(String str : strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String key = String.valueOf(cstr);
            List<String> ls = map.getOrDefault(key, new ArrayList<String>());
            ls.add(str);
            map.put(key, ls);
        }

        for(List<String> anagrams : map.values()) {
            ans.add(anagrams);
        }

        return ans;
    }
}