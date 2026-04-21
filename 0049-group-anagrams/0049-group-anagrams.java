class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);

            if(map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(sortedStr, ls); 
            }
        }

        return new ArrayList<>(map.values());
    }
}