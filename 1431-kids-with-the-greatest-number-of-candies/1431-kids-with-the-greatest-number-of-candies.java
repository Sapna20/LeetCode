class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int peak = Integer.MIN_VALUE;
        for(int x : candies) {
            peak = Math.max(peak, x);
        }

        List<Boolean> ls = new ArrayList<Boolean>();

        for(int x : candies) {
            ls.add(x + extraCandies >= peak);
        }

        return ls;
    }
}