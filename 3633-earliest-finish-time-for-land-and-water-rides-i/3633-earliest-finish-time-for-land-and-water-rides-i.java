class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;
        int m = landStartTime.length;
        int n = waterStartTime.length;

        for(int i=0; i<m; i++) {
            int currLandTime = landStartTime[i] + landDuration[i];
            for(int j=0; j<n; j++) {
                int currWaterTime = 0;
                if(currLandTime >= waterStartTime[j]) {
                    currWaterTime = waterDuration[j];
                } else {
                    currWaterTime = waterStartTime[j] - currLandTime + waterDuration[j];
                }
                minTime = Math.min(minTime, currLandTime + currWaterTime);
            }
        }

        for(int i=0; i<n; i++) {
            int currWaterTime = waterStartTime[i] + waterDuration[i];
            for(int j=0; j<m; j++) {
                int currLandTime = 0;
                if(currWaterTime >= landStartTime[j]) {
                    currLandTime = landDuration[j];
                } else {
                    currLandTime = landStartTime[j] - currWaterTime + landDuration[j];
                }
                minTime = Math.min(minTime, currLandTime + currWaterTime);
            }
        }
        
        return minTime;
    }
}