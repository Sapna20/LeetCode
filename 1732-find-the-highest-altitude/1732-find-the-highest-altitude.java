class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int currAlt = 0;
        
        for(int i=0; i<gain.length; i++) {
            currAlt += gain[i];
            max = Math.max(currAlt, max);
        }

        return max;
    }
}