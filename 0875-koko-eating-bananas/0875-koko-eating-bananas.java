class Solution {

    private boolean isValid(int mid, int[] piles, int h) {
        int n = piles.length;
        int total_hours = 0;

        for(int i=0; i<n; i++) {
            total_hours += Math.ceil((double)piles[i]/(double)mid);
        }

        return total_hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        int start = 1;
        int end = 0;

        for(int x : piles) {
            end = Math.max(end, x);
        }
        // System.out.println("end = " + end);

        while(start <= end) {
            int mid = (end-start)/2 + start;
            // System.out.println("mid = " + mid);
            if(isValid(mid, piles, h)) {
                k = mid;
                end = mid-1;
                // System.out.println("k = " + k);
            } else {
                start = mid+1;
            }
        }
        // System.out.println("piles[0] " + piles[0]);
        return k;
    }
}