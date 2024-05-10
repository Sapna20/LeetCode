class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> freq = new ArrayList<List<Integer>> ();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<n+1; i++) {
            List<Integer> ls = new ArrayList<Integer>();
            freq.add(ls);
        }

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                int c = map.get(nums[i]);
                map.put(nums[i], c+1);
            } else {
                map.put(nums[i], 1);
            }
        } 

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            freq.get(e.getValue()).add(e.getKey());
        }

        int[] ans = new int[k];
        int j=0;

        for(int i=n; i>0; i--) {
            if(!freq.get(i).isEmpty()) {
                for(int v : freq.get(i)) {
                    ans[j] = v;
                    j++;
                    if(j==k) {
                        break;
                    }
                }
                if(j==k) {
                    break;
                }
            }
        }

        return ans;
    }
}