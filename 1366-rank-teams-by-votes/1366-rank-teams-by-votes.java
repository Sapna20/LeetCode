class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rankTrack = new int[26][n];
        String ans = "";

        // prepare
        for(String vote : votes) {
            for(int i=0; i<n; i++) {
                Character letter = vote.charAt(i);
                rankTrack[letter - 'A'][i]++;
            }
        }

        // process
        // starter with temp ranking
        Character[] temp = new Character[n];

        for(int i=0; i<n; i++) {
            temp[i] = votes[0].charAt(i);
        }

        // sort ranking
        Arrays.sort(temp, (a, b) -> {
            for(int i=0; i<n; i++) {
                if(rankTrack[a - 'A'][i] != rankTrack[b - 'A'][i])
                    return rankTrack[b-'A'][i] - rankTrack[a-'A'][i];
            }
            return a-b;
        });
    
        for(Character c : temp) {
            ans += c;
        }

        return ans;
    }
}