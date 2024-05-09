class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {
            char[] tempArr = str.toCharArray();
            Arrays.sort(tempArr);
            String tempStr = String.valueOf(tempArr);
            if(map.containsKey(tempStr)) {
                map.get(tempStr).add(str);
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(tempStr, ls);
            }
        }

        List<List<String>> ans = new ArrayList<List<String>> ();

        for(List<String> value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}