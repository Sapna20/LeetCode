class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] peopleTrust = new int[n+1];

        for(int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];

            peopleTrust[a]--;
            peopleTrust[b]++;
        }

        for(int i=1; i<n+1; i++) {
            if(peopleTrust[i] == n-1)
                return i;
        }

        return trust.length == 0 && n==1 ? n : -1;
    }
}