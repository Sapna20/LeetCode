class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n;
        int bottom = m;
        int top = 0;
        int k =0;

        while(left < right && top < bottom) {
            for(int i=left; i < right; i++) {
                ls.add(matrix[top][i]);
            }
            top++;

            // // comment
            // for(int x : ls) {
            //     System.out.println(x);
            // } //

            for(int i=top; i < bottom; i++) {
                System.out.println("indices = " + right + ", " + i);
                ls.add(matrix[i][right-1]);
            }
            right--;

            // // comment
            // for(int x : ls) {
            //     System.out.println(x);
            // } //
    
            if(top >= bottom) {
                break;
            }
            for(int i=right-1; i >= left; i--) {
                ls.add(matrix[bottom-1][i]);
            }
            bottom--;

            // // comment
            // for(int x : ls) {
            //     System.out.println(x);
            // } //

            if(left >= right) {
                break;
            }
            for(int i=bottom-1; i >= top; i--) {
                ls.add(matrix[i][left]);
            }
            left++;

            // // comment
            // for(int x : ls) {
            //     System.out.println(x);
            // } //
        }

        return ls;
    }
}