class Solution {

    private long hoursTaken(int[] piles, int rate) { //r = 17 // r = 24 // r = 20 // r = 22
        long hrs = 0;
        for(int x : piles) {
            if(x % rate == 0) { //8 ----//6 ----// 7 // 2+1+2+1+1 = 7 // 2+1+1+1+1 = 6
                hrs += x/rate;  
            } else {
                hrs += x/rate + 1;
            }
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        
        for(int x : piles) {
            end = Math.max(x, end);
        }
        int rate = end;

        while(start <= end) { 
            int mid = (end-start)/2 + start; //17 // 24 // 20 // 22 // 23

            if(hoursTaken(piles, mid) <= h) { //  8 > 6 // 6 <= 6 // 7 > 6 //  6<=6
                rate = Math.min(rate, mid); 
                end = mid-1; // end = 23 // end = 21
            } else {
                start = mid+1;    // start = 18 // start = 21 // start = 23
            }
        }

        return rate;
    }
}