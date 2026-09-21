class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;

        while(i < j) {
            int curr_sum = numbers[i] + numbers[j];
            if(curr_sum == target) {
                return new int[]{i+1, j+1};
            } else if(curr_sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[2];
    }
}