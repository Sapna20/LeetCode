class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0, j=0, n=nums.length;
        int curr = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(j<n) {
            int key = nums[j];
            int count = map.getOrDefault(key, 0);
            // System.out.println(key + "--" + count);
            if(count < k) {
                map.put(key, count+1);
                curr++;
                max = Math.max(curr, max);
                j++;
                // System.out.println(key + "---");
            } else {
                while(key != nums[i]) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    i++;
                }
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
                curr = j-i;
                // System.out.println(key + "--------");
            }
        }

        return max;
    }
}