class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                map.put(key, ls);
            }
        }

        List<List<String>> ans = new ArrayList<List<String>>();

        for(List<String> ls : map.values()) {
            ans.add(new ArrayList<String>(ls));
        }

        return ans;
    }
}