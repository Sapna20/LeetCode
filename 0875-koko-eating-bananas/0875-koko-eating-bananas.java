class Solution {

    private int getTotalHoursByRate(int[] piles, int r) {
        int hrs = 0;
        for(int i=0; i<piles.length; i++) {
            hrs += (int)Math.ceil((double)piles[i]/r);
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int rates = Arrays.stream(piles).max().getAsInt();
        int start = 1, end = rates;
        int ans = rates;

        while(start <= end) {
            int mid = start + (end-start)/2;
            int tempH = getTotalHoursByRate(piles, mid);

            if(h >= tempH) {
                ans = Math.min(mid, ans);
                end = mid-1;
            } else if(h < tempH) {
                start = mid+1;
            }
        }

        return ans;
    }
}