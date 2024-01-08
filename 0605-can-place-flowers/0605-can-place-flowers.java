class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int m) {
        int n = flowerbed.length;
        for(int i=0; i<n; i++) {
            if(flowerbed[i] == 0) {
                if(i == 0 && (i+1 == n || flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    m--;
                } else if (i == n-1 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    m--;
                } else if ( i!=0 && i!=n-1 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    m--;
                }
            }
        }

        return m <= 0;
    }
}