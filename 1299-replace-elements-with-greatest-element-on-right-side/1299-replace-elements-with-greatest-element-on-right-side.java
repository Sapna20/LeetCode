class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max_so_far = arr[n-1];
        arr[n-1] = -1;

        for(int i=n-2; i>=0; i--) {
            int temp = arr[i];
            arr[i] = max_so_far;
            max_so_far = Math.max(max_so_far, temp);
        }

        return arr;
    }
}