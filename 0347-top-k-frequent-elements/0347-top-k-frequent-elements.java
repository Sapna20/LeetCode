class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] freq = new List[n+1];
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(freq[value] != null) {
                freq[value].add(key);
            } else {
                List<Integer> ls = new ArrayList<Integer>();
                ls.add(key);
                freq[value] = ls;
            }
        }

        int j=0;
        for(int i=n; i>=0; i--) {
            if(freq[i] != null) {
                for(Integer x : freq[i]) {
                    ans[j] = x;
                    j++;
                    if(j == k) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}