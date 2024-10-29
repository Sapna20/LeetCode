class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i=0, j=0;
        for(String command : commands) {
            switch(command) {
                case "RIGHT" :
                j++;
                break;
                case "LEFT" : 
                j--;
                break;
                case "UP" :
                i--;
                break;
                case "DOWN" :
                i++;
                break;
            }
        }

        return i*n+j;

    }
}