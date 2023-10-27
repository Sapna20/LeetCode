class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int n = candies.length;
        List<Boolean> ans = new ArrayList<Boolean>();
        int currMax = candies[0];
        
        for(int i=1; i<n; i++) {
            currMax = Math.max(currMax, candies[i]);
        }

        for(int i=0; i<n; i++) {
            Boolean b = currMax <= candies[i] + extraCandies;
            ans.add(b);
        }

        return ans;
    }
}