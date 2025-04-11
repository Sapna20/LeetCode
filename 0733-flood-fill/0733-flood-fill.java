class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;
        int orgColor = image[sr][sc];
        image[sr][sc] = color;

        if(orgColor == color)
            return image;

        if(sr+1 < m && image[sr+1][sc] == orgColor) {
            floodFill(image, sr+1, sc, color);
        } 
        if(sc+1 < n && image[sr][sc+1] == orgColor) {
            floodFill(image, sr, sc+1, color);
        } 
        if(sr-1 >= 0 && image[sr-1][sc] == orgColor) {
            floodFill(image, sr-1, sc, color);
        } 
        if(sc-1 >= 0 && image[sr][sc-1] == orgColor) {
            floodFill(image, sr, sc-1, color);
        } 

        return image;
    }
}