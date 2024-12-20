class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> temp = new HashSet<Integer>();
        int repeated=0;
        int sum=0;
        int n = nums.length;

        for(int x : nums) {
            if(temp.contains(x)) {
                repeated = x;
            }
            temp.add(x);
            sum += x;
        }

        int missing = n*(n+1)/2 - sum + repeated;
        int[] ans = new int[2];
        ans[0] = repeated;
        ans[1] = missing;

        return ans;
    }
}