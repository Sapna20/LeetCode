class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>> ();
        List<List<String>> ans = new ArrayList<List<String>> ();

        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);

            if(map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(s, ls);
            }
        } 

        for(List<String> val : map.values()) {
            if(val.size() > 0) {
                ans.add(val);
            }
        }

        return ans;
    }
}