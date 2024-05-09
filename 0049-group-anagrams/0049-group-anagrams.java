class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String,  ArrayList<String>>();

        for(String str : strs) {
            char[] tempArr = str.toCharArray();
            Arrays.sort(tempArr);
            String tempStr = String.valueOf(tempArr);
            if(map.containsKey(tempStr)) {
                map.get(tempStr).add(str);
            } else {
                ArrayList<String> ls = new ArrayList<String>();
                ls.add(str);
                map.put(tempStr, ls);
            }
        }

        List<List<String>> ans = new ArrayList<List<String>> ();

        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}