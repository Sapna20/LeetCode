class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int[] ans = new int[2];
        while(i<j) {
            int temp = numbers[i] + numbers[j];
            if( temp == target ) {
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            } else if ( temp < target ) {
                i++;
            } else if (temp > target) {
                j--;
            }
        }

        return ans;
    }
}