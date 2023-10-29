class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(i==0) {
                if((i+1 < flowerbed.length && flowerbed[i+1] == 1) || flowerbed[i] == 1) {
                    continue;
                }
            } else if(i == flowerbed.length-1) {
                if(flowerbed[i-1] == 1 || flowerbed[i] == 1) {
                    continue;
                }
            } else if(flowerbed[i-1] == 1 || flowerbed[i] == 1 || flowerbed[i+1] == 1) {
                continue;
            }
            flowerbed[i] = 1;
            n--;
        }

        return n<=0;
    }
}